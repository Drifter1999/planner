package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.*;
import com.codingbox.planner.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/listing")
@RequiredArgsConstructor
public class ListingCtroller {
    private final AccommodationService accommodationService;
    private final LeisureService leisureService;
    private final RestaurantService restaurantService;
    private final TourService tourService;
    private final DetailImagesService detailImagesService;

    @GetMapping("/details/{contentId}/{contentTypeId}")
    public String listingDetails(
            @PathVariable String contentId,
            @PathVariable String contentTypeId,
            Model model) {
        switch (contentTypeId) {
            case "12":
                List<TourDetailIntroDTO> TourApiArr = tourService.getApiResponse(contentId, contentTypeId);
                model.addAttribute("ApiArr", TourApiArr);
                break;
            case "28":
                List<LeisureDetailIntroDTO> LeisureApiArr = leisureService.getApiResponse(contentId, contentTypeId);
                model.addAttribute("ApiArr", LeisureApiArr);
                break;
            case "32":
                List<AccommodationDetailIntroDTO> AccomApiArr = accommodationService.getApiResponse(contentId, contentTypeId);
                model.addAttribute("ApiArr", AccomApiArr);
                break;
            case "39":
                List<RestaurantDetailDTO> RestauApiArr = restaurantService.getApiResponse(contentId, contentTypeId);
                model.addAttribute("ApiArr", RestauApiArr);
                break;
            default:
                return "home";
        }

        List<DetailsImagesDTO> ImgApiArr = detailImagesService.getApiResponse(contentId);
        model.addAttribute("ImgApiArr", ImgApiArr);

        return "listing_details";
    }
}
