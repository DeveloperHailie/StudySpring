# StudySpring 
개인적으로 Spring을 공부하는 공간입니다. <br>
강의를 듣고 따라한 프로젝트나 개인 프로젝트를 올리고 있습니다. (진행중)


## studySpring1
* 김영한 개발자님의 "인프런 : 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술"을 듣고 정리한 프로젝트 <br>
* 강의 링크 : https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8#curriculum <br>

1. 프로젝트 환경 설정 <br>
: Java11, IntelliJ, 스프링 부트 기반으로 스프링 프로젝트 생성 - https://start.spring.io/ <br>
: Gradle Project, Spring boot 2.3.1 <br>
: Dependencies(어떤 라이브러리 가져다 쓸지) = spring web, thymeleaf(템플릿 엔진) <br>
: IntelliJ에서 build.gradle open

2. 스프링 웹 개발 기초 <br>
: .idea = 인텔리제이가 사용하는 설정 파일<br>
: src > main = java(실제 코드) + resources(xml,html,property 등 설정 파일)<br>
: src > test = test 코드, 최근 개발 트렌드에서 중요<br>
: build.gradle<br>
: Gradle은 의존 관계가 있는 라이브러리를 함께 다운받는다. (So, External library가 엄청 많음)<br>
: Welcome Page 기능 (정적 page) = static/index.html 올려두면 Welcome Page 기능 제공<br>
: thymeleaf(타임리프) 템플릿 엔진 = 동적 페이지 _ 과거의 jsp/php. 서버에서 프로그래밍해서 html을 동적으로 바꿔서 내리는 것 <br>
: 웹 애플리케이션의 첫 진입점은 컨트롤러 <br>
: @Controller<br>
: @GetMapping("/") <br>
: @RequsestParam("name")String name = GET path?name=입력값<br>
: 컨트롤러에서 리턴값으로 문자를 반환 -> 뷰 리졸버가 화면을 찾아 처리(스프링 부트 템플릿 엔진 기본 view name 매핑)<br>
: 빌드하고 실행하는 방법 - window 기준<br>
  #0 IntelliJ에서 돌아가는 서버 중지 <br>
  #1 콘솔에서 작업 디렉토리로 이동 <br>
  #2 $gradlew build <br>
  #3 $cd build/libs <br>
  #4 $java -jar hello-spring-0.0.1~~~.jar <br>
: API = 서버끼리 통신할 때, 혹은 클라이언트에게 데이터 보낼 때 response body에 데이터를 넣어서 보낸다. 요즘에는 json 포맷으로 데이터 전송<br>
: Annotation = 주석처럼 코드에 달아 특별한 의미 부여/기능 주입 <br>
: @ResponseBody 메소드 반환 값이 단순 문자열(String)이라면? - response에 문자 넣어서 끝!<br>
: @ResponseBody 메소드 반환 값이 객체라면? - json 방식으로 데이터 만들어 response에 넣음! (getter, setter가 있어야 객체를 json으로 변환 가능)<br>

3. 회원 관리 예제 - 백엔드 개발<br>
: 비즈니스 요구 사항 = 데이터 : 회원 id, 이름 / 기능 : 회원 등록, 조회 / 아직 데이터 저장소가 선정되지 않았다고 가정 <br>
: 서비스 = 핵심 비즈니스 로직 ex) 중복 가입X <br>
: 도메인 = DB에 저장되는, 비즈니스 도메인 객체. ex) 회원, 주문 <br>
: 리포지토리 = DB에 접근, 도메인 객체를 DB에 저장하고 관리 <br>
: 아직 데이터 저장소가 선정되지 않았으므로, 초기 개발 단계에선 구현체로 메모리 기반의 데이터 저장소 사용. 따라서 MemberRepository interface를 만들고 구현체는 MemoryMemberRepository로 초기 개발 단계에선 구현체로 메모리 기반의 데이터 저장소 사용
: Optional<type>은 자바8에 들어간 기능으로, Integer/Double 클래스처럼 T type 객체를 포장해주는 일종의 Wrapper class다. null을 그대로 반환하지 않고 Optional로 감싸서 반환하는 것이 중요. <br>
: 테스트 케이스 작성 = 기존의 '자바의 main메서드 통해 실행하거나 웹 어플리케이션의 컨트롤러 통해 해당 기능 실행하여 테스트하는' 방법은 오래 걸리고 여러 케이스를 한번에 테스트 하기 힘듦. 따라서 JUnit이라는 프레임워크로 이를 해결 <br>
: 테스트 //given(조건, 상황) //when(실행, 이걸 검증할 거구나 알 수 있음) //then(결과) 이런 식으로 작성 <br>

4. 스프링 빈과 의존 관계<br>
: 의존성 주입 Dependency Injection - DI <br>
: 객체의존성 = 객체가 다르객체와 상호작용(참조)하고 있다면 객체는 다른 객체에 의존성 가짐. 하나의 모듈 바뀌면 다른 모듈까지 변경 필요 
-> 객체 자체가 아니라, 프레임워크에 의해 객체 의존성 주입.<br>
: 주입 = 내부가 아닌 외부에서 객체 생성해서 넣어주는 것<br>
: 즉 의존관계를 어떻게 부여하냐? 이런 느낌인듯<br>
: 필드 주입, setter 주입, 생성자 주입 있음 -> 의존관계가 실행 중 동적으로 변하는 경우는 거의 없으므로 생성자 주입 권장<br>
: 스프링 빈 등록하는 방법 2가지 = 컴포넌트 스캔과 자동 의존 관계 설정 / 자바 코드로 직접 스프링 빈 등록하기 (처음에는 1로 했다가 2로 변경)<br>
: why? 상황에 따라 구현 클래스 변경해야 할 시 자바코드로 직접 스프링 빈 등록하는 것이 유용 <br>
: 1. 컴포넌트 스캔과 자동 의존 관계 설정 <br>
: @Component 가 있으면 스트링 빈으로 자동 등록 <br>
: @Controller, @Service, @Repository는 @Component 포함하는 annotation이므로 스프링 빈으로 자동 등록 <br>
: @Autowired로 의존 관계 설정 (생성자 1개일땐 @Autowired 생략 가능) <br>
: 아무 위치에나 @붙이면 되는 건가? -> NO! @SpringBootApplication이 있는 패키지의 하위에 있는 것들을 뒤져서 스프링 빈으로 컴포넌트 스캔하는 것 <br>
: 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본적으로 싱글톤(유일하게 하나만 등록해서 공유)으로 등록한다. -> 같은 스프링 빈이면 모두 같은 인스턴스 <br>
: 2. 자바 코드로 직접 스프링 빈 등록하기 <br>
: @Controller는 그대로! @Service, @Repository, @Autowired 제거 후 진행 <br>
: SpringConfig.java 만듦(SpringBootApplication과 같은 위치에) <br>
: @Configuration <br>
: @Bean <br>

5. 회원 관리 예제 - 웹 MVC 개발<br>

6. 스프링 DB 접근 기술<br>
: H2 이용 (가벼운 database engine) <br>
: 1. (과거에 쓰던 방식인) 순수 jdbc <br>
: build.gradle dependencies에 jdbc와 h2 라이브러리 추가 <br>
: application.properties에 url과 driver-class-name 추가 (원래 id, pwd도 적은데 h2라 생략)<br>
: 기존에 만들어놓은 interface인 MemberRepository를 implements하는 JdbcMemberRepository를 만듦.<br>
: SpringConfig 변경<br>
: OCP(Open-Closed Principle) 개방 폐쇄 원칙 = 확장에는 열려있고 수정(변경)에는 닫혀있다. 다형성을 잘 활용하면(인터페이스 구현체를 바꾸면서) 기존 코드 전혀 손대지 않고 설정만으로 구현 클래스 변경 가능 <br>
: + 스프링 통합 테스트 <br>
: @SpringBootTest = 스프링 컨테이너와 테스트 함께 실행<br>
: @Transactional = 테스트 실행 시 트랜잭션 먼저 실행 후 test 끝나면 롤백(why? Test는 반복할 수 있어야 함 -> DB에 넣었던 내용 반영 안 되게!)<br>
: 3.에서 했던 테스트 케이스(=순수산 JAVA CODE로 작성한, 최소한의 단위 테스트) -> 단위 테스트! (지금 한 것은 스프링 컨테이너, db 연동한 스프링 통합 테스트)<br>
: 단위 테스트처럼 스프링 컨테이너 없이 테스트 할 수 있도록 훈련 -> db연동 후는 HOW? -> 테스트 전용 가짜 repository(mock 객체, mockito 가짜 객체 만들어주는 라이브러리 주로 사용) 만들어서 테스트 시점에 넣어주기<br>
: 2. 스프링 JDBC 템플릿 <br>
: 순수 jdbc와 동일한 환경설정, JDBC API에서 본 반복코드 대부분 제거<br>
: SQL문은 직접 작성<br>
: 3. JPA <br>
: JPA는 기존의 반복 코드 + 기본적인 SQL도 jpa가 직접 만들어서 실행해줌 <br>
: SQL, 데이터 중심 설계 -> 객체 중심의 설계로 패러다임 전환<br>
: build.gradle에 data-jpa 라이브러리 추가<br>
: properties에 jpa.show-sql=true(jpa가 날리는 쿼리문 본다) jpa.hibernate.ddl-auto=create(객체보고 테이블 다 만들어줌, 근데 우린 이미 다 있으니까 none으로 설정)<br>
: ORM(Object Relational Mapping) <br>
: @Entity = Entity 매핑, JPA가 관리하는 객체<br>
: db에 값 넣으면 id 자동으로 생성 - identity 전략<br>
: @Id @GeneratedValue(strategy=GenerationType.IDENTITY)<br>
: @Column(name="username")<br>
: JPA 사용 시 주의 = Service 계층에서(데이터 변경하는 부분) @Transactional 있어야 함<br>
: 즉, JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다. <br>
: 4. 스프링 데이터 JPA <br>
: JPA를 편리하게 사용하도록 도와주는 기술<br>
: JPA 설정 그대로<br>
: 스프링 부트와 JPA라는 기반 위 스프링 데이터 JPA라는 프레임워크<br>
: 인터페이스를 통한 기본 CRUD 기능도 제공<br>
: findByName(), findByEmail()처럼 메소드 이름만으로 조회 기능 제공<br>
: 페이징 기능 자동 제공<br>
: 복잡한 동적 쿼리는 Querydsl 라이브러리 사용. 혹은 JPA가 제공하는 네이티브 쿼리 사용하거나 스프링 JdbcTemplate 사용 <br>
: 스프링 데이터 JPA가 SpringDataJpaMemberRepository(JpaRepository를 상속받는 interface)를 스프링 빈으로 자동 등록 해줌(알아서 구현체 만들어서 등록)<br>

7. AOP<br>
: Aspect Oriented Programming<br>
: 공통 관심 사항과 핵심 관심 사항을 분리<br>
: 예시 ) 모든 메소드의 호출 시간을 측정하고 싶다면?<br>
: 시간 측정 기능 = 공통 관심 사항 / 핵심 비즈니스 로직(회원가입, 조회 ..) = 핵심 관심 사항<br>
: 다른 말로는 cross-cutting concern / core concern<br>
: 만약 이 둘(시간 측정 로직과 핵심 비즈니스 로직)이 분리가 안 되어 있다면 유지보수가 어려움<br>
: 그래서 AOP 기술로 이 둘을 분리하여, 공통 관심 사항을 원하는 곳에 적용하자!<br>
: @Aspect <br>
: @Around("execution(*.hello.hellospring..*(..))") = 보통 패키지 level로 이거 적용할 곳 정함<br>
: AOP 동작 방식?<br>
: (AOP 적용 전) memberController가 memberService 호출<br>
: (AOP 적용 후) memberController가 Proxy memberService(가짜) 호출. 프록시 memberService가 joinPoint.Proceed()하면 그 때 실제 memberService 호출<br>
: MemberController 생성자에서 memeberService class 이름 출력해서 확인해보자!<br>
: => 시간 측정 로직을 별도의 공통 로직으로 만들면서 핵심 관심 사항을 깔끔하게 유지할 수 있고 변경이 필요할 시 공통 관심 사항만 변경하면 되며, 원하는 적용 대상 선택 가능.<br>
: 스프링 빈으로 등록할 때 1. 컴포넌트 스캔과 자동 의존 관계 설정 vs 2. 자바 코드로 직접 등록 <br>
: 1. 이용하여 @Controller 하면 아무 문제 없이 등록 <br>
: 2. 자바 코드로 직접 등록(Config에 @Bean으로 등록) 시 빈 순환 참조 에러 발생 <br>
: why? TimeTraceAop의 AOP 대상을 지정하는 @Around를 보면 SpringConfig의 timeTraceAop() 메서드도 AOP로 처리. 그런데 이게 바로 자기 자신인 TimeTraceAop를 생성하는 코드. so 순환참조 문제 발생 <br>
:@Around("execution(* com.infreanSpring.studySpring1..*(..)) && !target(com.infreanSpring.studySpring1.SpringConfig)") = AOP 대상에서 SpringConfig 빼줘서 문제 해결<br>

8. 다음으로<br>


## studySpring2
* boostcourse의 웹 백엔드 강의를 듣고 정리한 프로젝트 <br>
* 강의 링크 : https://www.boostcourse.org/web326/joinLectures/28762 <br>

1. MySQL <br>
: DBMS (오라클, SQL Server, MySQL, db2 ...) <br>
: DB = 데이터베이스, 데이터의 집합, 여러 응용 시스템들의 통합된 정보들을 저장하여 운영할 수 있는 공용 데이터의 집합 <br>
: DB 특성 = 실시간 접근성(사용자 요구 즉시 처리 가능), 계속적 변화(지속적 갱신), 동시 공유성, 내용 참조(저장한 데이터 위치가 아닌 사용자가 요구하는 데이터 내용_값에 따라 참조할 수 있어야 한다)  <br>
: DBMS = 데이터베이스를 관리하는 소프트웨어, 여러 응용 소프트웨어/시스템이 동시에 DB에 접근하여 사용할 수 있게 함 <br>
: DBMS 필수 3기능 = 정의기능(논리적, 물리적 구조 정의), 조작 기능(데이터 검색, 삭제, 갱신 등), 제어 기능(DB의 내용 정확성과 안전성 유지하도록 제어) <br>
: DBMS 장점 = 데이터 중복이 최소화, 데이터 일관성 및 무결성 유지, 데이터 보안 보장 <br>
: DBMS 단점 = 운영비가 비싸다, 백업 및 복구에 대한 관리 복잡, 부분적 데이터베이스 손실이 정체 시스템 정지 <br>



