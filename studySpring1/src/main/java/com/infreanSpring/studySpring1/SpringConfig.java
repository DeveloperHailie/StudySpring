package com.infreanSpring.studySpring1;

import com.infreanSpring.studySpring1.aop.TimeTraceAop;
import com.infreanSpring.studySpring1.repository.*;
import com.infreanSpring.studySpring1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);

        //data를 Memory 저장에서 Db 저장으로 바꿀 시
        //MemoryMemberRepository를 DBMemberRepository로 변환하면 된다.

    }
*/
}
