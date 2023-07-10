package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	//	@Autowired
	//	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/", true))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/signup").permitAll()
						.requestMatchers("/login").permitAll()
						.anyRequest().authenticated())
				.csrf().disable();

		return http.build();
	}

	/*
	@Bean
	public UserDetailsService users() {
		//インメモリ認証
		//平文{noop}のパスワードでユーザーを生成
		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}password")
				.authorities("ADMIN")
				.build();
		UserDetails user = User.builder()
				.username("user")
				.password("{noop}password")
				.authorities("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
		
	}
	*/

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
