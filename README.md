# springboot-aws
&#128216;[스프링부트와 AWS로 혼자 구현하는 웹서비스 - 이동욱] 클론코딩 토이프로젝트입니다

&#127775; 새로 익힌 것
- Unit test
- JPA / Hibernate / Spring Data Jpa의 관계
- Repository, domain, service, controller
- JPA Auditing로 등록, 수정 시간 자동화
- 머스테치
- 스프링부트는 기본적으로 src/main/resources/static에 위치한 자바스크립트, CSS, 이미지 등 정적파일들은 URL에서 /로 설정됨
- @Transactional(readOnly = true)를 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선되기 때무넹 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천
- 람다식
    ```java
  postsRepository.findAllDesc().stream() 
                  .map(PostsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                  .collect(Collectors.toList());
  ```
    - postsRepository 결과로 넘어온  Posts의 Stream을 map을 통해 PostsListPesponseDto로 변환 -> List로 반환
&#128565; 이슈해결목록 &#128565;
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