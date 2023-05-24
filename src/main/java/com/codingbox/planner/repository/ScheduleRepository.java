package com.codingbox.planner.repository;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMembersToSchedule(Members members);

    @Query("SELECT s FROM Schedule s WHERE s.membersToSchedule.userId like :userId")
    List<Schedule>cntUserSchedule (@Param("userId") String userId);
}
