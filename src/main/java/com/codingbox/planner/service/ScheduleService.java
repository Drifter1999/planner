package com.codingbox.planner.service;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.domain.Schedule;
import com.codingbox.planner.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> cntUserSchedule (String userId) {
        return scheduleRepository.cntUserSchedule(userId);
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> getScheduleByMembers(Members members) {
        return scheduleRepository.findByMembersToSchedule(members);
    }

    public void shareScheduleWithColleague(String colleagueId, Schedule schedule) {
        // Implement the logic to share the schedule with the colleague
        // This could involve updating the schedule entity with the colleague's ID
        // or performing any necessary actions to notify the colleague
        // You can use the scheduleRepository or other relevant dependencies to update the schedule
    }
}
