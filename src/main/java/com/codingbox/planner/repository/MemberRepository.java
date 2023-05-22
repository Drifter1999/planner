package com.codingbox.planner.repository;

import com.codingbox.planner.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MemberRepository extends JpaRepository<Members, String> {


    Members findByuserId(String userId);

    Members findByName(String name);

}