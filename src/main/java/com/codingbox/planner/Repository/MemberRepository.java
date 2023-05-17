package com.codingbox.planner.Repository;


import com.codingbox.planner.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

// 어노테이션레포지토리 , 엔티티매니저,팩토리  , 엔티티 트랜잭션
// db연결방법 = 스프링샵 (참고)
@Repository
@Table(name="MEMBERS")
public interface MemberRepository extends JpaRepository<Members, String> {


    Members findByuserId(String userId);
}










