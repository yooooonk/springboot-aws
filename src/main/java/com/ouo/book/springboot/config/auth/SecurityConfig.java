package com.ouo.book.springboot.config.auth;

import com.ouo.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션들을 disable
        .and()
            .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점, antMatcher 옵션을 사용할 수 있게됨
            // antMatchers : 권한 관리 대상을 지정하는 옵션
            .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll() // permitAll()은 전체 열람 권한
            .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER권한을 가진 사람만 열람
            .anyRequest().authenticated() // anyRequest : 설정된 것 외에 나머지 URL들, authenticated : 나머지 URL들은 모두 인증된 사용자들에게마 ㄴ허용
        .and()
            .logout() // 로그아웃 기능에 대한 여러 설정의 진입점
                .logoutSuccessUrl("/") // 로그아웃 성공시 /주소로 이동
        .and()
            .oauth2Login() // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                    .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
        ; //
    }
}
