package com.ouo.book.springboot.domain.posts;

import com.ouo.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entity class에서는 절대 Setter 메소드를 만들지 않는다
@Getter
@NoArgsConstructor // 기본생성자 자동추가
@Entity // 테이블과 링크될 클래스. CamelCase -> _네이밍으로 테이블 매핑
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙
    private Long id;

    // 테이블의 칼럼. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됨.
    // 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을 때
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 빌드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

