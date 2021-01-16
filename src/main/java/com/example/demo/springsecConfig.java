package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.Encoder;

@Configuration
@EnableTransactionManagement
@EnableWebSecurity
public class springsecConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
        //auth.inMemoryAuthentication().withUser("harsh").password("harsh").roles("ADMIN");
        //auth.inMemoryAuthentication().withUser("ha").password("ha").roles("USER");
    }
    @Override

    protected void configure(HttpSecurity http) throws Exception { http
            .csrf().disable() .authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/gendata").hasRole("ADMIN")
            .antMatchers("/log").hasAnyRole("USER","ADMIN")
            .antMatchers("/").permitAll()
            .antMatchers("/sendmail").permitAll()
            .antMatchers("/resetpass").permitAll()
            .antMatchers("/entrotp").permitAll()
            .antMatchers("/newpass").permitAll()
            .antMatchers("/finalreset").permitAll()
            .antMatchers("/signup").permitAll()
            .antMatchers("/signsubmit").permitAll()
            .antMatchers("/sub").permitAll()
            .antMatchers("/verifyotp").permitAll()
            .antMatchers("/enterotp1").permitAll()
            .antMatchers("/temp").permitAll()
            .antMatchers("/getres").permitAll()
            .antMatchers("/submitForm.web").permitAll()
            .anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login")
            //.httpBasic()
            ; }
  @Bean BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
  }
}
