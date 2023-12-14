package com.csb.appadvcmidterms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/", "/contact","/Login*", "/AboutUs", "/SignUp*")
                .permitAll()

                .antMatchers("/user*", "/doctor*").hasRole("ADMIN")

                .antMatchers("/Appointment*" ).hasAnyRole("ADMIN", "USER")

                .anyRequest()
                    .authenticated()

                .and()
                    .formLogin()
                    .loginPage("/Login")
                    .defaultSuccessUrl("/Appointment/Reservation", true)
                    .usernameParameter("emailAddress")
                .and()
                    .logout()
                    .permitAll();
    }
}


