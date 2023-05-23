package com.codingbox.planner.service;

import com.codingbox.planner.domain.DTO.SearchKeyWordDTO;
import com.codingbox.planner.domain.DTO.TourDetailIntroDTO;
import com.codingbox.planner.openAPI.OpenAPI;
import com.codingbox.planner.parser.ApiJsonParser;
import com.codingbox.planner.parser.ParsingToList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TourService {
    public List<TourDetailIntroDTO> getApiResponse(String contentId, String contentTypeId) {

        String API_URL = new OpenAPI().createDetailIntroURL(contentId, contentTypeId);
        try {
            URL url = new URL(API_URL);
// HTTP Header 객체 생성 및 설정
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-type", "application/json")
                    .build();

            HttpResponse<String> Httpresponse = HttpClient
                    .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String resp = Httpresponse.body();
            JSONObject Parsed = new ApiJsonParser().ApiParser(resp);
            JSONArray jsonArr = (JSONArray) Parsed.get("item");
            System.out.println("jsonArr : " + jsonArr + "!");
            List<TourDetailIntroDTO> resultList = new ParsingToList().findTourIntroArray(jsonArr);

            return resultList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
