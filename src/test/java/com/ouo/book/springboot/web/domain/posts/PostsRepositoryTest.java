package com.ouo.book.springboot.web.domain.posts;

import com.ouo.book.springboot.domain.posts.PostRepository;
import com.ouo.book.springboot.domain.posts.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class )
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @After // Junit에서 단위테스트가 끝날 때마다 수행되는 메서드
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("ouo_yoook@naver.com")
                .build());

        // when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
