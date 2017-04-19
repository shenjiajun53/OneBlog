package com.joni.config;

import com.joni.repository.UserRepository;
import com.joni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * Created by shenjj on 2017/4/7.
 */

//@ComponentScan
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public UserService userService() {
//        return new UserService();
//    }
//
//    @Bean
//    public TokenBasedRememberMeServices rememberMeServices() {
//        TokenBasedRememberMeServices tokenBasedRememberMeServices = new TokenBasedRememberMeServices("remember-me-key", userService());
//        return tokenBasedRememberMeServices;
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler successHandler() {
//        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
//        handler.setUseReferer(true);
//        return handler;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new StandardPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth
////                .eraseCredentials(true)
//                .userDetailsService(userService())
////                .passwordEncoder(passwordEncoder())
//        ;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//        http
//                .formLogin().loginPage("/api/SignIn")
////                .loginProcessingUrl("/")
////                .successForwardUrl("/api/getAllBlogs")
//                .defaultSuccessUrl("/api/SignInSuccess", true)
//                .failureUrl("/api/SignInFailed")
////                .successHandler(successHandler())
//                .permitAll()
//                .and()
//                .logout().logoutUrl("/api/SignOut")
//                .logoutSuccessUrl("/api/SignOutSuccess")
//                .permitAll()
//                .and()
//                .rememberMe().key("remember-me-key")
////                .rememberMeServices(rememberMeServices())
//                .alwaysRemember(true)
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/MyFollow").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/api/").hasRole("USER")
//                .anyRequest().permitAll();
//    }
}
