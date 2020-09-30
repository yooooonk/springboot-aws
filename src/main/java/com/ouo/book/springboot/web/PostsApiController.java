package com.ouo.book.springboot.web;

import com.ouo.book.springboot.domain.posts.PostsService;
import com.ouo.book.springboot.web.dto.PostsResponseDto;
import com.ouo.book.springboot.web.dto.PostsSaveRequestDto;
import com.ouo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    // @RequiredArgsConstructor로 생성자를 만들어 bean을 주입받음
    // @authwired는 권장하지 않음
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}