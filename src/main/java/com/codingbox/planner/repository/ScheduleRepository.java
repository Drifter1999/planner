package com.codingbox.planner.repository;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMembersToSchedule(Members members);
}
