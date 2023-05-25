package com.codingbox.planner.repository;

import com.codingbox.planner.domain.ShareSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharedScheduleRepository extends JpaRepository<ShareSchedule, Long> {

    @Query("SELECT ss FROM ShareSchedule ss WHERE ss.scheduleToShare.Id = :scheduleId")
    List<ShareSchedule> findScheduleIds(@Param("scheduleId") Long scheduleId);

    @Query(value = "SELECT * FROM (SELECT * FROM SHARE_SCHEDULE ss WHERE SCHEDULE_ID = :ScheduleId AND ROWNUM = 1)", nativeQuery = true)
    ShareSchedule findScheduleOneByOne(@Param("ScheduleId") Long ScheduleId);
}
