package com.codingbox.planner.service;

import com.codingbox.planner.domain.DTO.ScheduleCartDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleCartService {
    private int Id = 0;
    public List<ScheduleCartDTO> createCartList (String startDate, String endDate, String contentTitleList, String contentName) {
        List<ScheduleCartDTO> CartArr = new ArrayList<ScheduleCartDTO>();
        String [] str = contentTitleList.split(",");

        for (int i = 0 ; i < str.length ; i++) {
            ScheduleCartDTO data = new ScheduleCartDTO();
            Id+=1;
            data.setScheduleCartId(Id);
            data.setStrDate(startDate);
            data.setEndDate(endDate);
            data.setContentTitleList(str[i]);
            data.setContentName(contentName);

            CartArr.add(data);
        }
        return CartArr;
    }
}
