package com.ticket.TicketOrderService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //    .csrf().disable()//this is for non-browser
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())//Here in this csrf token will be stored in cookies
               // .and()
                .authorizeRequests()
                //THis permits only following url's "/home" and "/users"
                .antMatchers("/booking/booked/").hasRole("USER")
                .antMatchers("/booking/addBooking","/booking/update/","/booking/del/").hasRole("ADMIN")

                //.antMatchers("/abc").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.httpBasic();
                .formLogin();
              //  .loginPage("/abc")
               // .loginProcessingUrl("/signin")
              //  .defaultSuccessUrl("/users/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("Sid").password(this.pass().encode("Sid")).roles("NORMAL");
        auth.inMemoryAuthentication().withUser("Siddhu").password(this.pass().encode("siddhu")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Siddharth").password(this.pass().encode("Siddharth")).roles("USER");
    }
    @Bean
    public PasswordEncoder pass(){

        return new BCryptPasswordEncoder(10);
    }
}