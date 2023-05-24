package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.AreaDTO;
import com.codingbox.planner.domain.DTO.ScheduleCartDTO;
import com.codingbox.planner.domain.DTO.ScheduleDTO;
import com.codingbox.planner.domain.DTO.SearchKeyWordDTO;
import com.codingbox.planner.service.ListingService;
import com.codingbox.planner.service.MultiSelectService;
import com.codingbox.planner.service.ScheduleCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/header")
@RequiredArgsConstructor
public class  HeaderController {
    private final ListingService listingService;
    private final MultiSelectService multiSelectService;

    private final ScheduleCartService scheduleCartService;



    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/category")
    public String category(Model model) {
        List<AreaDTO> ApiArr = multiSelectService.getApiAreaResponse();
        model.addAttribute("ApiArr", ApiArr);
        return "category";
    }

    @GetMapping("/listing")
    public String listing(@RequestParam("area") String area,
            @RequestParam("content") String content,
            Model model) throws JsonProcessingException {

        List<SearchKeyWordDTO> ApiArr = listingService.getApiResponse(area, content);
        model.addAttribute("ApiArr", ApiArr);

        return "listing";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/blogDetails")
    public String blogDetails() {
        return "blogdetails";
    }

    @GetMapping("/blog")
    public String blog(@RequestParam ("shareData") String shareData , @RequestParam ("Id") String Id) {;
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(shareData);
            JSONArray jsonArray = (JSONArray) obj.get("scheduleData");

            List<String> shareDTOArr = new ArrayList<>();

            System.out.println("Id : " + Id);

            for (int i = 0 ; i < jsonArray.size() ; i++) {
                JSONObject data = (JSONObject) jsonArray.get(i);
                System.out.println(data);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "blog";
    }

    @GetMapping("/elements")
    public String elements() {
        return "elements";
    }

    @GetMapping("/listing_details")
    public String listingDetailsRedirect() {
        return "redirect:/listing/details";
    }

    @PostMapping("/Calendar")
    public String Calendar(@RequestParam("startDate") String startDate,
                           @RequestParam("endDate") String endDate,
                           @RequestParam("contentTitleList") String contentTitleList,
                           @RequestParam("ContentType") String ContentType,
                           Model model, HttpSession httpSession) throws ParseException {
        contentTitleList = contentTitleList.substring(0, contentTitleList.length()-2);
        contentTitleList = contentTitleList.replaceAll("\"", "");
        String contentName = "";
        switch (ContentType) {
            case "12" : contentName = "관광지"; break;
            case "28" : contentName = "레포츠"; break;
            case "32" : contentName = "숙박"; break;
            case "39" : contentName = "음식점"; break;
            default:
                System.out.println("잘못된 값입니다.");
        }

        List<ScheduleCartDTO> CartArr;
        if (httpSession.getAttribute("CartArrSec")!= null &&
                !String.valueOf(httpSession.getAttribute("CartArrSec")).equals("[]")){
            String SessionString =  String.valueOf(httpSession.getAttribute("CartArrSec"));
            SessionString = SessionString.replaceAll("\\[|\\]", "");

            String[] SessionArrayList = SessionString.split("\\),");
            ArrayList<ScheduleCartDTO> SessionArr= new ArrayList<>();

            for (String item : SessionArrayList ) {
                item = item.replace("ScheduleCartDTO(", "");
                item = item.replace(")", "");
                String [] str = item.split(",");
                List<String> strData = new ArrayList<String>();
                for (int i = 0 ; i <  str.length ; i++){
                    String [] tempStr = str[i].split("=");
                    strData.add(tempStr[1]);
                }
                ScheduleCartDTO data = new ScheduleCartDTO();

                data.setScheduleCartId(Integer.parseInt(strData.get(0)));
                data.setStrDate(strData.get(1));
                data.setEndDate(strData.get(2));
                data.setContentTitleList(strData.get(3));
                data.setContentName(strData.get(4));

                SessionArr.add(data);
            }

            CartArr = scheduleCartService.createCartList(startDate, endDate, contentTitleList, contentName);
            for (int i = 0 ; i < CartArr.size() ; i++) {
                SessionArr.add(CartArr.get(i));
            }
            httpSession.setAttribute("CartArrSec", SessionArr);

        }else {

            CartArr = scheduleCartService.createCartList(startDate, endDate, contentTitleList, contentName);
            httpSession.setAttribute("CartArrSec", CartArr);
        }

        Object value = httpSession.getAttribute("CartArrSec");

        model.addAttribute("CartArr", value);


        return "Calendar";
    }

}
