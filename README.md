# springboot-aws
&#128216;[스프링부트와 AWS로 혼자 구현하는 웹서비스 - 이동욱] 클론코딩 토이프로젝트입니다


&#128565; 이슈해결목록 &#128565;
- git에 ignore 파일빼고 커밋했는데 repository 삭제하고 커밋해도 재설정없이 같은 상태로 커밋됨 ㅠㅠ
    - git remote rm' 명령어 / 'git update-ref -d HEAD'로 initial commit 되돌리기
- 톰캣접속시 sign창 뜨는 문제
    - pring security 때문 -> username : name / password에 콘솔창에 뜨는 Using generated secureity password 입력
- 롬복 처음 설정하고 테스트하는데 'variable name not initialized in the default constructor' 에러나면서 fail - @RequiredArgsConstructor가 작동안해서 final 변수에 생성자 생성안된듯
    - lombok 설정이 gralde버전 5로 오면서 많이 달라졌기때문. 
    - gradlew wrapper --gradle-version 4.10.2   명령어로 gradle다운그레이드