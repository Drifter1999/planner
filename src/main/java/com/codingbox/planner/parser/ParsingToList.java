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
}
