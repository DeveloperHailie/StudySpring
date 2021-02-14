package com.infreanSpring.studySpring1.repository;

import com.infreanSpring.studySpring1.domain.Member;

import java.util.List;
import java.util.Optional;

// 데이터 저장소 선정되지 않았으므로 interface로 구현
public interface MemberRepository {

    Member save(Member member); //회원 등록
    Optional<Member> findById(Long id); //아이디로 회원 찾기
    Optional<Member> findByName(String name); //이름으로 회원 찾기
    List<Member> findAll();

}
