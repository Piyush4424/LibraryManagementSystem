//package com.piyushcodes.librarymanagementsystem.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.
//		     authorizeHttpRequests()
//		     .antMatchers("/admin/**").permitAll()
//		     .antMatchers("/student/**").hasAuthority("student")
//		     .and()
//		     .formLogin()
//		     .and()
//		     .csrf().disable();
//		     
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder getPasswordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//    
//}
