package com.cloud.microservicio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder)  throws Exception{

        PasswordEncoder password = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder user = User.builder().passwordEncoder(password::encode);

        builder.inMemoryAuthentication().withUser(user.username("elliot").password("1234").roles("ADMIN","USER"))
                .withUser(user.username("carlos").password("1234").roles("USER"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**","/img/**","/js/**").permitAll()
                .antMatchers("/cliente/**").hasRole("USER").anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/cliente/listar").permitAll()
                .and().logout().permitAll();
    }

}
