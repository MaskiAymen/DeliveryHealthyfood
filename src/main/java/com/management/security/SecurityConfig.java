package com.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**");


        httpSecurity.authorizeHttpRequests().requestMatchers("/Home").hasAnyRole("ADMIN","CASHIER","LIVREUR","USER");
       httpSecurity.authorizeHttpRequests().requestMatchers("/createProduct","/saveProduct").hasAnyRole("ADMIN","CASHIER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/showProduct", "/updateProduct", "/deleteProduct").hasAnyRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/productsList").hasAnyRole("ADMIN","CASHIER","USER");

        httpSecurity.authorizeHttpRequests().requestMatchers("/createCommande","/saveCommande").hasAnyRole("ADMIN","CASHIER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/showCommande", "/updateCommande", "/deleteCommande").hasAnyRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/commandesList").hasAnyRole("ADMIN","CASHIER","LIVREUR");

    httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");

        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        return httpSecurity.build();
    }
   @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return  new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("livreur").password(passwordEncoder.encode("123")).roles("LIVREUR").build(),
                User.withUsername("cashier").password(passwordEncoder.encode("123")).roles("CASHIER").build()


        );

    }
   // @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);

    }

}
