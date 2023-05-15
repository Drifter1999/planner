package com.codingbox.planner.Repository;

import com.codingbox.planner.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members, Integer> {
    public Members findByName(String name);
}
