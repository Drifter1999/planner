package com.codingbox.planner.parser;

import com.codingbox.planner.domain.DTO.*;
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
    public List<AccommodationDetailIntroDTO> findAccomIntroArray(JSONArray jsonArr) throws ParseException {
        List<AccommodationDetailIntroDTO> introArr = new ArrayList<AccommodationDetailIntroDTO>();

        for (int i = 0 ; i < jsonArr.size(); i++) {
            AccommodationDetailIntroDTO data = new AccommodationDetailIntroDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setContentid(String.valueOf(jsonObj.get("contentid")));
            data.setContenttypeid(String.valueOf(jsonObj.get("contenttypeid")));
            data.setGoodstay(String.valueOf(jsonObj.get("goodstay")));
            data.setBenikia(String.valueOf(jsonObj.get("benikia")));
            data.setHanok(String.valueOf(jsonObj.get("hanok")));
            data.setRoomcount(String.valueOf(jsonObj.get("roomcount")));
            data.setRoomtype(String.valueOf(jsonObj.get("roomtype")));
            data.setRefundregulation(String.valueOf(jsonObj.get("refundregulation")));
            data.setCheckintime(String.valueOf(jsonObj.get("checkintime")));
            data.setCheckouttime(String.valueOf(jsonObj.get("checkouttime")));
            data.setChkcooking(String.valueOf(jsonObj.get("chkcooking")));
            data.setSeminar(String.valueOf(jsonObj.get("seminar")));
            data.setSports(String.valueOf(jsonObj.get("sports")));
            data.setSauna(String.valueOf(jsonObj.get("sauna")));
            data.setBeauty(String.valueOf(jsonObj.get("beauty")));
            data.setBeverage(String.valueOf(jsonObj.get("beverage")));
            data.setCampfire(String.valueOf(jsonObj.get("campfire")));
            data.setBicycle(String.valueOf(jsonObj.get("bicycle")));
            data.setFitness(String.valueOf(jsonObj.get("fitness")));
            data.setPublicpc(String.valueOf(jsonObj.get("publicpc")));
            data.setPublicbath(String.valueOf(jsonObj.get("publicbath")));
            data.setSubfacility(String.valueOf(jsonObj.get("subfacility")));
            data.setFoodplace(String.valueOf(jsonObj.get("foodplace")));
            data.setReservationurl(String.valueOf(jsonObj.get("reservationurl")));
            data.setPickup(String.valueOf(jsonObj.get("pickup")));
            data.setInfocenterlodging(String.valueOf(jsonObj.get("infocenterlodging")));
            data.setParkinglodging(String.valueOf(jsonObj.get("parkinglodging")));
            data.setReservationlodging(String.valueOf(jsonObj.get("reservationlodging")));
            data.setScalelodging(String.valueOf(jsonObj.get("scalelodging")));
            data.setAccomcountlodging(String.valueOf(jsonObj.get("accomcountlodging")));
            introArr.add(data);
        }
        return introArr;
    }

    public List<LeisureDetailIntroDTO> findLeisureIntroArray(JSONArray jsonArr) throws ParseException {
        List<LeisureDetailIntroDTO> leisureArr = new ArrayList<LeisureDetailIntroDTO>();

        for (int i = 0 ; i < jsonArr.size(); i++) {
            LeisureDetailIntroDTO data = new LeisureDetailIntroDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setContentid(String.valueOf(jsonObj.get("contentid")));
            data.setContenttypeid(String.valueOf(jsonObj.get("contenttypeid")));
            data.setOpenperiod(String.valueOf(jsonObj.get("openperiod")));
            data.setReservation(String.valueOf(jsonObj.get("reservation")));
            data.setInfocenterleports(String.valueOf(jsonObj.get("infocenterleports")));
            data.setScaleleports(String.valueOf(jsonObj.get("scaleleports")));
            data.setAccomcountleports(String.valueOf(jsonObj.get("accomcountleports")));
            data.setRestdateleports(String.valueOf(jsonObj.get("restdateleports")));
            data.setUsetimeleports(String.valueOf(jsonObj.get("usetimeleports")));
            data.setExpagerangeleports(String.valueOf(jsonObj.get("expagerangeleports")));
            data.setParkingleports(String.valueOf(jsonObj.get("parkingleports")));
            data.setParkingleports(String.valueOf(jsonObj.get("parkingfeeleports")));
            data.setParkingleports(String.valueOf(jsonObj.get("chkbabycarriageleports")));
            data.setParkingleports(String.valueOf(jsonObj.get("chkpetleports")));
            data.setParkingleports(String.valueOf(jsonObj.get("chkcreditcardleports")));

            leisureArr.add(data);
        }
        return leisureArr;
    }

    public List<RestaurantDetailDTO> findRestIntroArray(JSONArray jsonArr) throws ParseException {
        List<RestaurantDetailDTO> restauArr = new ArrayList<RestaurantDetailDTO>();

        for (int i = 0 ; i < jsonArr.size(); i++) {
            RestaurantDetailDTO data = new RestaurantDetailDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setContentid(String.valueOf(jsonObj.get("contentid")));
            data.setContenttypeid(String.valueOf(jsonObj.get("contenttypeid")));
            data.setSeat(String.valueOf(jsonObj.get("seat")));
            data.setKidsfacility(String.valueOf(jsonObj.get("kidsfacility")));
            data.setFirstmenu(String.valueOf(jsonObj.get("firstmenu")));
            data.setTreatmenu(String.valueOf(jsonObj.get("treatmenu")));
            data.setSmoking(String.valueOf(jsonObj.get("smoking")));
            data.setPacking(String.valueOf(jsonObj.get("packing")));
            data.setInfocenterfood(String.valueOf(jsonObj.get("infocenterfood")));
            data.setScalefood(String.valueOf(jsonObj.get("scalefood")));
            data.setParkingfood(String.valueOf(jsonObj.get("parkingfood")));
            data.setOpendatefood(String.valueOf(jsonObj.get("opendatefood")));
            data.setOpentimefood(String.valueOf(jsonObj.get("opentimefood")));
            data.setRestdatefood(String.valueOf(jsonObj.get("restdatefood")));
            data.setDiscountinfofood(String.valueOf(jsonObj.get("discountinfofood")));
            data.setChkcreditcardfood(String.valueOf(jsonObj.get("chkcreditcardfood")));
            data.setReservationfood(String.valueOf(jsonObj.get("reservationfood")));
            data.setLcnsno(String.valueOf(jsonObj.get("lcnsno")));

            restauArr.add(data);
        }
        return restauArr;
    }

    public List<TourDetailIntroDTO> findTourIntroArray(JSONArray jsonArr) throws ParseException {
        List<TourDetailIntroDTO> TourArr = new ArrayList<TourDetailIntroDTO>();

        for (int i = 0 ; i < jsonArr.size(); i++) {
            TourDetailIntroDTO data = new TourDetailIntroDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setContenttypeid(String.valueOf(jsonObj.get("contentid")));
            data.setContenttypeid(String.valueOf(jsonObj.get("contenttypeid")));
            data.setHeritage1(String.valueOf(jsonObj.get("heritage1")));
            data.setHeritage1(String.valueOf(jsonObj.get("heritage2")));
            data.setHeritage1(String.valueOf(jsonObj.get("heritage3")));
            data.setInfocenter(String.valueOf(jsonObj.get("infocenter")));
            data.setOpendate(String.valueOf(jsonObj.get("opendate")));
            data.setRestdate(String.valueOf(jsonObj.get("restdate")));
            data.setExpguide(String.valueOf(jsonObj.get("expguide")));
            data.setExpgerange(String.valueOf(jsonObj.get("expgerange")));
            data.setAccomcount(String.valueOf(jsonObj.get("accomcount")));
            data.setUseseason(String.valueOf(jsonObj.get("useseason")));
            data.setUsetime(String.valueOf(jsonObj.get("usetime")));
            data.setParking(String.valueOf(jsonObj.get("parking")));
            data.setChkbabycarriage(String.valueOf(jsonObj.get("chkbabycarriage")));
            data.setChkpet(String.valueOf(jsonObj.get("chkpet")));
            data.setChkcreditcard(String.valueOf(jsonObj.get("chkcreditcard")));

            TourArr.add(data);
        }
        return TourArr;
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

    public List<DetailsImagesDTO> findImageArray(JSONArray jsonArr) throws ParseException {
        List<DetailsImagesDTO> imagesArr = new ArrayList<DetailsImagesDTO>();

        for (int i = 0 ; i < jsonArr.size() ; i++) {
            DetailsImagesDTO data = new DetailsImagesDTO();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(jsonArr.get(i).toString());

            data.setContentid(String.valueOf(jsonObj.get("contentid")));
            data.setOriginimgurl(String.valueOf(jsonObj.get("originimgurl")));
            data.setImgname(String.valueOf(jsonObj.get("imgname")));
            data.setSmallimageurl(String.valueOf(jsonObj.get("smallimageurl")));
            data.setCpyrhtDivCd(String.valueOf(jsonObj.get("cpyrhtDivCd")));
            data.setSerialnum(String.valueOf(jsonObj.get("serialnum")));

            imagesArr.add(data);
        }
        return imagesArr;
    }
}
