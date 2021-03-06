package com.infreanSpring.studySpring1.service;

import com.infreanSpring.studySpring1.domain.Member;
import com.infreanSpring.studySpring1.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //Given
        Member member = new Member();
        member.setName("spring0");

        //When
        long saveId = memberService.join(member);

        //Then
        Member findMember = memoryMemberRepository.findById(saveId).get();
        assertThat(member.getId()).isEqualTo(findMember.getId());
    }

    @Test
    void 중복_회원_예외() {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        // 2(logic)을 할 때 1(error)가 발생해야 함
        IllegalStateException e = assertThrows(IllegalStateException.class,
                ()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}