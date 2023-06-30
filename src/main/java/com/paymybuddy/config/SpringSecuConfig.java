package com.paymybuddy.config;

import com.paymybuddy.service.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SpringSecuConfig {



    private final JpaUserDetailsService jpaUserDetailsService;
    public SpringSecuConfig(JpaUserDetailsService jpaUserDetailsService){
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

   @Bean
   public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
   {
       http
               .authorizeRequests(authorizeRequests ->
                       authorizeRequests
                               .requestMatchers("/login").permitAll()
                               .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                               .anyRequest().authenticated()
               )
               .formLogin(formLogin ->
                       formLogin
                               .loginPage("/login")
                               .defaultSuccessUrl("/home", true)
               )
               .userDetailsService(jpaUserDetailsService)
               .logout(Customizer.withDefaults());
       return http.build();
   }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new MessageDigestPasswordEncoder("SHA-256");
    }


}
