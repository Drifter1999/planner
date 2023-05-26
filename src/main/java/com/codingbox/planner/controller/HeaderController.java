package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.*;
import com.codingbox.planner.domain.Party;
import com.codingbox.planner.domain.Schedule;
import com.codingbox.planner.domain.ShareSchedule;
import com.codingbox.planner.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping(value = "/header")
@RequiredArgsConstructor
public class  HeaderController {
    private final ListingService listingService;
    private final MultiSelectService multiSelectService;

    private final ScheduleCartService scheduleCartService;
    private final ScheduleService scheduleService;
    private final MemberService memberService;
    private final PartyService partyService;
    private final SharedScheduleService sharedScheduleService;


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

    @GetMapping("/schedule")
    public String scheduleView (Model model, HttpSession httpSession){
        List<ShareSchedule> ShareScheduleList = (List<ShareSchedule>) httpSession.getAttribute("ShareScheduleList");
        model.addAttribute("ShareScheduleList", ShareScheduleList);
        String scheduleUrl = "schedule"; // 전환할 페이지의 URL
        return scheduleUrl;
    }

    @PostMapping("/sharedPlanner")
    public ResponseEntity<String> schedulePlanner(@RequestParam("userId") String userId,
                                                  Model model, HttpSession httpSession) {
        System.out.println("userId : " + userId);
        List<Party> shareUserList = partyService.findUserSchedule(userId);
        System.out.println("shareUserList : " + shareUserList);
        List<ShareSchedule> shareScheduleList = new ArrayList<>();

        for (int i = 0 ; i < shareUserList.size() ; i++){
            Long ScheduleId = shareUserList.get(i).getSchedule().getId();
            ShareSchedule shareSchedule = sharedScheduleService.findSchedulesOneByOne(ScheduleId);

            shareScheduleList.add(shareSchedule);
        }

        model.addAttribute("ShareScheduleList", shareScheduleList);
        httpSession.setAttribute("ShareScheduleList", shareScheduleList);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Forward-Url", "/header/schedule");
        return new ResponseEntity<>("Forward request", headers, HttpStatus.OK);
    }

    @GetMapping("/sharedetails")
    public String blogDetails(Model model,@RequestParam("scheduleId") Long scheduleId) {
        List<ShareSchedule> shareScheduleList = sharedScheduleService.findScheduleIds(scheduleId);
        JSONArray jsonArr = new JSONArray();

        for (ShareSchedule shareSchedule : shareScheduleList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("title", shareSchedule.getDestination());
            jsonObj.put("start", shareSchedule.getStrDate().replace(".","-"));
            jsonObj.put("end", shareSchedule.getEndDate().replace(".","-"));
            jsonObj.put("itinerary", true);
            jsonArr.add(jsonObj);
        }

        model.addAttribute("shareScheduleList", shareScheduleList);
        model.addAttribute("jsonArr", jsonArr.toJSONString());
        return "sharedetails";
    }

    @PostMapping("/shared")
    public ResponseEntity<String> shared (@RequestParam("ShareData") String shareData,
                               @RequestParam("Id") String id,
                               @RequestParam("Members") String members,
                               @RequestParam("Title") String title,
                               Model model) {
        Long SharedScheduleId = 0L;
        try {
            shareData = shareData.replace("'","");
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(shareData);
            JSONArray jsonArray = (JSONArray) obj.get("scheduleData");

            Schedule schedule = new Schedule();
            schedule.setMembersToSchedule(memberService.findByUserId(id));
            scheduleService.createSchedule(schedule);

            SharedScheduleId = schedule.getId();

            members+=id;
            String [] membersList = members.split(",");

            for (int i = 0 ; i < membersList.length ; i++) {
                membersList[i] = membersList[i].replace(",","");
                Party data = new Party();
                Optional<Schedule> OptionalSchedule = scheduleService.getScheduleById(schedule.getId());
                Schedule scheduleDTO = OptionalSchedule.get();
                data.setSchedule(scheduleDTO);
                data.setMembersToParty(memberService.findByUserId(membersList[i]));
                partyService.createParty(data);
            }

            for (int i = 0 ; i < jsonArray.size() ; i++) {
                JSONObject jsonObj = (JSONObject) jsonArray.get(i);

                ShareSchedule data= new ShareSchedule();

                Optional<Schedule> OptionalSchedule = scheduleService.getScheduleById(schedule.getId());
                Schedule scheduleDTO = OptionalSchedule.get();

                data.setScheduleToShare(scheduleDTO);
                data.setStrDate(String.valueOf(jsonObj.get("startDate")));
                data.setEndDate(String.valueOf(jsonObj.get("endDate")));
                data.setTitle(title);
                data.setDestination(String.valueOf(jsonObj.get("destination")));

                sharedScheduleService.createShareSchedule(data);
            }
            model.addAttribute("scheduleId", String.valueOf(schedule.getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Forward-Url", "/header/sharedetails?scheduleId="+SharedScheduleId);
        return new ResponseEntity<>("Forward request", headers, HttpStatus.OK);
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
        //세션이 있다면
        if (httpSession.getAttribute("CartArrSec")!= null &&
                !String.valueOf(httpSession.getAttribute("CartArrSec")).equals("[]")){

            String SessionString =  String.valueOf(httpSession.getAttribute("CartArrSec"));
            //기존 세션 값 가져옴
            SessionString = SessionString.replaceAll("\\[|\\]", "");

            String[] SessionArrayList = SessionString.split("\\),");
            List<ScheduleCartDTO> SessionArr= new ArrayList<>();

            for (String item : SessionArrayList){
                item = item.replace("ScheduleCartDTO(", "");
                item = item.replace(")", "");
                String [] str = item.split(",");
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 0 ; i < str.length ; i++) {

                    String [] tempStr = str[i].trim().split("=");
                    map.put(tempStr[0], tempStr[1]);
                }
                ScheduleCartDTO prevData = new ScheduleCartDTO();

                prevData.setScheduleCartId(Integer.parseInt(map.get("ScheduleCartId")));
                prevData.setContentTitleList(map.get("contentTitleList"));
                prevData.setContentName(map.get("contentName"));
                prevData.setStrDate(map.get("strDate"));
                prevData.setEndDate(map.get("endDate"));

                SessionArr.add(prevData);
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
