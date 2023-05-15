package com.codingbox.planner.openAPI;

public class OpenAPI {
    private String URL="";
    private String EndPoint = "http://apis.data.go.kr/B551011/KorService1/";
    private String MyKey = "omp%2Fmeb3nLI8AmaNmwy0F32toS6aSGsSQqcjKQ70S3we5zi4uB%2FfuYMbZm64Q8QLT1wH6gVNoAPJVocDQ1FV1A%3D%3D";

    private String Application = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    public String createSearchKeywordURL (String Area, String Content) {
        String area = Area.trim();
        String contentType = Content.trim();

        switch (contentType) {
            case "관광지" :
                contentType = "12";
                break;

            case "레포츠" :
                contentType = "28";
                break;

            case "숙박" :
                contentType = "32";
                break;

            case "음식점" :
                contentType = "39";
                break;
        }

        URL = EndPoint + "searchKeyword1?" + "ServiceKey=" +MyKey + Application + "&keyword=" + area + "&numOfRows=1000" + "&contentTypeId=" + contentType;

        return URL;
    };
}
