package com.example.demo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
  
  // 기본적으로 security는 2개 UserDetailsService, PasswordEncoder를 구현해야 한다.
  // UserDetailsService는 어떻게 사용자 정보를 가져올지를 결정한다. UserDetails Interface로 정의된다.
  // UserDetailsManager는 경우 사용자를 삭제하거나 생성하는 것 같은 추가 적인 기능을 제공하는 interface이다.
  // userDetails을 내부에서 관리해야 한다.
  @Bean
  UserDetailsService userDetailsService() {
    // InMemoryUserDetailsManager is implementing UserDetailsService
    var manager = new InMemoryUserDetailsManager();
    var pilseong = User.withUsername("pilseong")
      .password("qwe123")
      .authorities("read")
      .build();

    manager.createUser(pilseong);

    return manager;
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
