package com.joni.config;

import com.joni.repository.UserRepository;
import com.joni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

/**
 * Created by shenjj on 2017/4/7.
 */

@ComponentScan
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices tokenBasedRememberMeServices = new TokenBasedRememberMeServices("remember-me-key", userService());
        return tokenBasedRememberMeServices;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.
                userDetailsService(userService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .formLogin().loginPage("/api/SignIn")
//                .loginProcessingUrl("/")
                .successForwardUrl("/MyFollow")
                .and()
                .logout().logoutUrl("/api/SignOut")
                .logoutSuccessUrl("/")
                .and()
                .rememberMe().key("remember-me-key").alwaysRemember(true)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/MyFollow").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/").hasRole("USER")
                .anyRequest().permitAll();
    }
}
