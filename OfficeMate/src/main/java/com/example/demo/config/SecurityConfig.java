package com.example.demo.config;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.example.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final CustomUserDetailsService customUserDetailsService;
	
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider());
        return authenticationManagerBuilder.build();
    }
	@Bean
	public SessionRegistry sessionRegistry() {	//사용자 세션정보 추적
	    return new SessionRegistryImpl();
	}

	@Bean
	public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() { //세션 생명주기를 추적할 수 있도록 도와준다. 이를 통해 세션이 생성되거나 소멸될 때 적절한 이벤트를 발생시켜서 SessionRegistry 같은 컴포넌트가 이를 인식하고 관리할 수 있게 한다.
	    return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/login", "/join", "/loginProc", "/joinProc", "/css/**", "/images/**").permitAll() // 해당 설정 경로는 인증 없이 접근 가능
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            );
            
        http
	        .formLogin((auth) -> auth
	                .loginPage("/login")
	                .loginProcessingUrl("/loginProc")
	                .defaultSuccessUrl("/home") // 로그인 성공 시 /home으로 리디렉션
	                .permitAll()	
            );
        http
        	.logout((auth) -> auth
        			.logoutUrl("/logout")
        			.logoutSuccessUrl("/")
        	);
//        http
//        	.httpBasic(Customizer.withDefaults());	//http basic 인증방식  폼x
        	
//        http
//        	.csrf((auth) -> auth
//        			.disable());
        
        http
        	.sessionManagement((auth) -> auth
        			.maximumSessions(1)	//하나의 아이디에 대한 다중 로그인 허용 개
        			.maxSessionsPreventsLogin(true)	//다중 로그인 개수를 초과하였을 경우 새로운 로그인
        			.sessionRegistry(sessionRegistry())
        	); 
        
        http
        	.sessionManagement((auth -> auth
        			.sessionFixation().changeSessionId())	//로그인 시 동일한 session에 대한 id 변경
        			);

        return http.build();
    }
   
    
    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("password")
//            .roles("USER")
//            .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//            .username("admin")
//            .password("admin123")
//            .roles("ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}