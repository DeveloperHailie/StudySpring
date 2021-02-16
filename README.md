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
: 웹 애플리케이션의 첫 진입점은 컨트롤러<br>
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
: 의존성 주입 Dependency Injection - DI ?<br>
: 객체의존성(객체가 다르객체와 상호작용(참조)하고 있다면 객체는 다른 객체에 의존성 가짐. 하나의 모듈 바뀌면 다른 모듈까지 변경 필요) 
-> 객체 자체가 아니라, 프레임워크에 의해 객체의존성 주입.<br>
: 주입 ? 내부가 아닌 외부에서 객체 생성해서 넣어주는 것<br>
: 필드 주입, setter 주입, 생성자 주입 있음 -> 의존관계가 실행 중 동적으로 변하는 경우는 거의 없으므로 생성자 주입 권장<br>
: 스프링 빈을 등록하는 방법 2가지 = 컴포넌트 스캔과 자동 의존 관계 설정 / 자바 코드로 직접 스프링 빈 등록하기<br>
: 상황에 따라 구현 클래스 변경해야 할 시 자바코드로 직접 스프링 빈 등록하는 것이 유용 <br>

5. 회원 관리 예제 - 웹 MVC 개발<br>

6. 스프링 DB 접근 기술<br>
: H2 이용 (가벼운 database engine) <br>
: (과거에 쓰던 방식인) 순수 jdbc <br>
: build.gradle dependencies에 jdbc와 h2 라이브러리 추가 <br>
: application.properties에 url과 driver-class-name 추가 (원래 id, pwd도 적은데 h2라 생략)<br>
: 기존에 만들어놓은 interface인 MemberRepository를 implements하는 JdbcMemberRepository를 만듦.<br>
: SpringConfig 변경<br>
: OCP(Open-Closed Principle) 개방 폐쇄 원칙 = 확장에는 열려있고 수정(변경)에는 닫혀있다. 다형성을 잘 활용하면(인터페이스 구현체를 바꾸면서) 기존 코드 전혀 손대지 않고 설정만으로 구현 클래스 변경 가능 <br>

7. AOP<br>

8. 다음으로<br>
