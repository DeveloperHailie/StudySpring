package com.infreanSpring.studySpring1.repository;

import com.infreanSpring.studySpring1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 초기 개발 단계에선 구현체로 가벼운 메모리 기반의 데이터 저장소 사용
// 동시성 문제 고려X, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
public class MemoryMemberRepository implements MemberRepository{

    // 저장소
    private static Map<Long, Member> store = new HashMap<>();
    // id 생성 위한 변수
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // member에 id 부여한 후 store에 save
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // id 값으로 store에 저장된 member 찾기
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // name 값으로 store에 저장된 member 찾기
        // 람다식 이용
        // name 은 value

        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();

        /*
        * # Stream
        * (이전) 자바 컬렉션/배열 원소 가공 시 for문, foreach 등 원소 하나씩 골라내서 가공
        * (Stream) 람다 함수 형식으로 간결하고 깔끔하게 요소 처리 가능
        * map() 특정 조건에 해당하는 값으로 변환
        * filter() 조건에 따라 요소 거름
        * sorted() 요소 정렬
        * list.stream().map(s->s.toUpperCase());
        * list.stream().filter(t->t.length()>5));
        * list.stream().sorted();
        *
        * # findAny()
        * 스트림이 비어있는 경우 비어있는 Optional 객체 반환
        * */
    }

    @Override
    public List<Member> findAll() {
        // 모든 member 반환
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
