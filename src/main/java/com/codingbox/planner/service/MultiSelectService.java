package com.codingbox.planner.service;

import com.codingbox.planner.domain.DTO.AreaDTO;
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
public class MultiSelectService {
    public List<AreaDTO> getApiAreaResponse() {

        String API_URL = new OpenAPI().createSearchAreaCodeURL();

        try {
            URL url = new URL(API_URL);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-type", "application/json")
                    .build();

            HttpResponse<String> Httpresponse = HttpClient
                    .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String resp = Httpresponse.body();
            JSONObject Parsed = new ApiJsonParser().ApiParser(resp);
            JSONArray jsonArr = (JSONArray) Parsed.get("item");

            List<AreaDTO> result = new ParsingToList().findAreaArray(jsonArr);

            System.out.println(result);

            return result;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
