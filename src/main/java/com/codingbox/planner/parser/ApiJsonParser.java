package com.codingbox.planner.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiJsonParser {

    public JSONObject ApiParser(String resp) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(resp);
        JSONObject jsonResp = (JSONObject) jsonObject.get("response");
        JSONObject jsonBody = (JSONObject) jsonResp.get("body");
        JSONObject jsonItems = (JSONObject) jsonBody.get("items");


        return jsonItems;
    }

    public JSONObject DetailImageParser(String resp) throws ParseException{
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(resp);
        JSONObject jsonResp = (JSONObject) jsonObject.get("response");
        JSONObject jsonBody = (JSONObject) jsonResp.get("body");

        return jsonBody;
    }

}
