package com.codingbox.planner.service;

import com.codingbox.planner.domain.ShareSchedule;
import com.codingbox.planner.repository.SharedScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SharedScheduleService {
    private final SharedScheduleRepository sharedScheduleRepository;

    public ShareSchedule createShareSchedule(ShareSchedule shareSchedule) {
        return sharedScheduleRepository.save(shareSchedule);
    }

    public Optional<ShareSchedule> findByOne(Long id) {
        return sharedScheduleRepository.findById(id);
    }

    public List<ShareSchedule> findScheduleIds(Long scheduleId) {
        return sharedScheduleRepository.findScheduleIds(scheduleId);
    }

    public ShareSchedule findSchedulesOneByOne (Long ScheduleId) {
        return sharedScheduleRepository.findScheduleOneByOne(ScheduleId);
    }

}
