package com.codingbox.planner.parser;

import com.codingbox.planner.domain.DTO.AreaDTO;
import com.codingbox.planner.domain.DTO.SearchKeyWordDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class ParsingToList {
    public List<SearchKeyWordDTO> createArray (JSONArray jsonArr) throws ParseException {
        List<SearchKeyWordDTO> resultList = new ArrayList<>();
        for (int i = 0 ; i < jsonArr.size() ; i++){
            SearchKeyWordDTO data = new SearchKeyWordDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setAddr1(String.valueOf(jsonObj.get("addr1")));
            data.setAddr2(String.valueOf(jsonObj.get("addr2")));
            data.setAreacode(String.valueOf(jsonObj.get("areacode")));
            data.setBooktour(String.valueOf(jsonObj.get("booktour")));
            data.setCat1(String.valueOf(jsonObj.get("cat1")));
            data.setCat2(String.valueOf(jsonObj.get("cat2")));
            data.setCat3(String.valueOf(jsonObj.get("cat3")));
            data.setContentid(String.valueOf(jsonObj.get("contentid")));
            data.setContenttypeid(String.valueOf(jsonObj.get("contenttypeid")));
            data.setCreatedtime(String.valueOf(jsonObj.get("createdtime")));
            data.setFirstimage(String.valueOf(jsonObj.get("firstimage")));
            data.setFirestimage2(String.valueOf(jsonObj.get("firestimage2")));
            data.setPyrhtDivCd(String.valueOf(jsonObj.get("pyrhtDivCd")));
            data.setMapx(String.valueOf(jsonObj.get("mapx")));
            data.setMapy(String.valueOf(jsonObj.get("mapy")));
            data.setMlevel(String.valueOf(jsonObj.get("mlevel")));
            data.setModifiedtime(String.valueOf(jsonObj.get("modifiedtime")));
            data.setSigungucode(String.valueOf(jsonObj.get("sigungucode")));
            data.setTel(String.valueOf(jsonObj.get("tel")));
            data.setTitle(String.valueOf(jsonObj.get("title")));

            resultList.add(data);
        }
        return resultList;
    }

    public List<AreaDTO> findAreaArray(JSONArray jsonArr) throws ParseException {
        List<AreaDTO> areaArr = new ArrayList<AreaDTO>();

        for (int i = 0 ; i < jsonArr.size(); i++) {
            AreaDTO data = new AreaDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setCode(String.valueOf(jsonObj.get("code")));
            data.setName(String.valueOf(jsonObj.get("name")));
            data.setRnum(Integer.parseInt(String.valueOf(jsonObj.get("rnum"))));

            areaArr.add(data);
        }
        return areaArr;
    }

    public List<String> AreaJsonArray (String province) {
        List<String> Area = new ArrayList<String>();
        String[] StringArea = new String[0];
        switch (province) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "31":
                StringArea = new String[]{"수원", "성남", "의정부", "안양", "부천", "광명", "평택", "동두천", "안산", "고양", "과천", "구리", "남양주", "오산", "시흥", "군포", "의왕", "하남", "용인", "파주", "이천", "안성", "김포", "화성", "광주", "양주", "포천", "여주"};
                break;
            case "32":
                StringArea = new String[]{"춘천", "원주", "강릉", "동해", "태백", "속초", "삼척"};
                break;
            case "33":
                StringArea = new String[]{"청주", "충주", "제천"};
                break;
            case "34":
                StringArea = new String[]{"천안", "공주", "보령", "아산", "서산", "논산", "계룡", "당진"};
                break;
            case "35":
                StringArea = new String[]{"포항", "경주", "김천", "안동", "구미", "영주", "영천", "상주", "문경", "경산"};
                break;
            case "36":
                StringArea = new String[]{"창원", "진주", "통영", "사천", "김해", "밀양", "거제", "양산"};
                break;
            case "37":
                StringArea = new String[]{"전주", "군산", "익산", "정읍", "남원", "김제"};
                break;
            case "38":
                StringArea = new String[]{"목포", "여수", "순천", "나주", "광양"};
                break;
            case "39":
                StringArea = new String[]{"제주", "서귀포"};
                break;
            default:
                System.out.println("Province 값 오류");
                break;
        }

        for (int i = 0 ; i < StringArea.length ; i++ ) {
            Area.add(StringArea[i]);
        }

        return Area;
    }
}
