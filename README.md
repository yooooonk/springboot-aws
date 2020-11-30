# &#128216;스프링부트와 AWS로 혼자 구현하는 웹서비스 - 이동욱

## &#127754; 목차
### 1. spring boot 프로젝트 만들고, grealde 설정

### 2. 게시글 CRUD 화면 및 로직만들기

### 3. 구글 OAuth 설정
- __세션 값 받아오는 어노테이션 생성__
    - 'LoginUser' annotation
    - LoginUserArgumentResolver Class
        - HandlerMethodArgumentResolver 인터페이스를 구현한 클래스
        - 조건에 맞는 경우 메소드가 있다면 HandlerMethodArgumentResolver의 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있음
    - WebConfig 클래스 생성
        - LoginMvcConfigurer가 스프링에서 인식될 수 있도록 
- __세선 저장소로 데이터베이스 사용하기__
  - spring-session-jdbc 등록 : build.gradle에 의존성 등록
        compile('org.springframework.boot:spring-boot-starter-oauth2-client')
  - application.properties에 spring.session.store-type=jdbc 추가 (세선 저장소를 jdbc로 선택하도록)
- __네이버 로그인__

### 4. AWS 서버 환경 만들기
- AWS 인스턴스 생성, 서버 기본 설정
- RDS 생성 및 설정, 접속

### 5. EC2 서버에 프로젝트 배포
- EC2에 스프링부트 프로젝트 배포
- 쉘 스크립트 작성
- 스프링부트 프로젝트와 AWS RDS 연동방법
- EC2에서 구글, 네이버 로그인 설정방법

### 5. 배포자동화


## &#127775; 새로 익힌 것
- Unit test
- JPA / Hibernate / Spring Data Jpa의 관계
- Repository, domain, service, controller
- JPA Auditing로 등록, 수정 시간 자동화
- 머스테치
- 스프링부트는 기본적으로 src/main/resources/static에 위치한 자바스크립트, CSS, 이미지 등 정적파일들은 URL에서 /로 설정됨
- @Transactional(readOnly = true)를 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선되기 때문에 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천
- 람다식
 ```java
  postsRepository.findAllDesc().stream() 
                  .map(PostsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                  .collect(Collectors.toList());
  ```
    - postsRepository 결과로 넘어온  Posts의 Stream을 map을 통해 PostsListPesponseDto로 변환 -> List로 반환


### &#128565; 이슈해결목록 &#128565;
- lombok 어노테이션 인식 못해서 생기는 문제들 
    - IDE 재시작..ㅜ
- git에 ignore 파일빼고 커밋했는데 repository 삭제하고 커밋해도 재설정없이 같은 상태로 커밋됨 ㅠㅠ
    - git remote rm' 명령어 / 'git update-ref -d HEAD'로 initial commit 되돌리기
- 톰캣접속시 sign창 뜨는 문제
    - pring security 때문 -> username : name / password에 콘솔창에 뜨는 Using generated secureity password 입력
- 롬복 처음 설정하고 테스트하는데 'variable name not initialized in the default constructor' 에러나면서 fail - @RequiredArgsConstructor가 작동안해서 final 변수에 생성자 생성안된듯
    - lombok 설정이 gralde버전 5로 오면서 많이 달라졌기때문. 
    - gradlew wrapper --gradle-version 4.10.2   명령어로 gradle다운그레이드
- 테스트 코드 실행시 'Test events were not received'메시지
    -  Preference > Build, Execution, Deployment > Build Tools > Gradle 로 이동해서 Run tests using 을 IntelliJ IDEA 로 설정
    - 출처 https://balhae79.tistory.com/387 [조영's lab Dev]