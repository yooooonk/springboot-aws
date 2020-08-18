package com.ouo.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복기능테스트(){
        String name = "test";
        int amount = 1000;
        
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        
        //assertThat : 테스트 검증 라이브러리의 검증메서드, 검증하고 싶은 대상을 메서드 인자로 받는다
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmout()).isEqualTo(amount);
                
    }

}
