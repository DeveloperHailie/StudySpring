package com.infreanSpring.studySpring1;

import com.infreanSpring.studySpring1.repository.JdbcMemberRepository;
import com.infreanSpring.studySpring1.repository.MemberRepository;
import com.infreanSpring.studySpring1.repository.MemoryMemberRepository;
import com.infreanSpring.studySpring1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
        /*
        data를 Memory 저장에서 Db 저장으로 바꿀 시
        MemoryMemberRepository를 DBMemberRepository로 변환하면 된다.
        * */
    }
}
