package com.codingbox.planner.openAPI;

public class OpenAPI {
    private String URL="";
    private String EndPoint = "http://apis.data.go.kr/B551011/KorService1/";
    private String MyKey = "kDibu3INqbH12ckTpQRsNKrGmhso7zRMORODMsFLWVlJX49%2BRj%2FtZOAxQ0PVhhLEeegpYJc9E0ReNoZyOaX%2Fmw%3D%";

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

    public String createSearchAreaCodeURL() {
        URL = EndPoint + "areaCode1?"
                + "ServiceKey="+ MyKey
                + Application + "&numOfRows=20";
        return URL;
    }
}
