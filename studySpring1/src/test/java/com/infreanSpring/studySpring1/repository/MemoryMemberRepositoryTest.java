package com.infreanSpring.studySpring1.repository;

import com.infreanSpring.studySpring1.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 @Test 끝날 때마다 호출, 콜백함수
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        //Given
        Member member = new Member();
        member.setName("spring0");

        //When
        repository.save(member);

        //Then
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member,result);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById(){
        //Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //When
        Member result = repository.findById(member1.getId()).orElseThrow(()->new NoSuchElementException());

        //Then
        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findByName(){
        //Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //When
        Member result = repository.findByName(member1.getName()).orElse(null);

        //Then
        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll(){
        //Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //When
        List<Member> result = repository.findAll();

        //Then
        Assertions.assertThat(2).isEqualTo(result.size());
    }


}
