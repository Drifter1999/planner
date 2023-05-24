package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.ShareScheduleDTO;
import com.codingbox.planner.domain.Members;
import com.codingbox.planner.domain.Schedule;
import com.codingbox.planner.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

    private final ScheduleService scheduleService;

    @Autowired
    public CalendarController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/schedules/{id}")
    public Optional<Schedule> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PostMapping("/schedules")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }

    @GetMapping("/schedules/members")
    public List<Schedule> getScheduleByMembers(@RequestBody Members members) {
        return scheduleService.getScheduleByMembers(members);
    }

    @PostMapping("/share")
    public void shareScheduleWithColleague(@RequestBody ShareScheduleDTO request) {
        logger.info("Received share request for schedule with ID: {}", request.getScheduleId());
        logger.debug("Shared schedule details: {}", request);
        logger.info("ValueCheck : ", request.toString());
        // Log a confirmation message
        logger.info("Schedule shared successfully with colleague: {}", request.getColleagueId());
    }
}
