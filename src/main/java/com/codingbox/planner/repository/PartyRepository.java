package com.codingbox.planner.repository;

import com.codingbox.planner.domain.DTO.PartyDTO;
import com.codingbox.planner.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, String> {
    @Query("SELECT p FROM Party p where p.membersToParty.userId = :UserId")
    List<Party> findUserSchedule(@Param("UserId") String UserId);

    /*@Query("SELECT count(s.Id) \n" +
            "FROM ShareSchedule ss, Schedule s \n" +
            "WHERE ss.scheduleToShare.Id = s.Id \n" +
            "AND s.membersToSchedule.userId LIKE  :UserId")
    int countUserSchedule (@Param("UserId") String UserId);*/
}
