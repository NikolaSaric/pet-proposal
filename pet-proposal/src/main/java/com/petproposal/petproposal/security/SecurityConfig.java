package com.petproposal.petproposal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService loginService;
	
	private PasswordEncoder passwordEncoder;

	public SecurityConfig(LoginService loginService, PasswordEncoder passwordEncoder) {
		this.loginService = loginService;
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder amb) throws Exception {
		amb
		.userDetailsService(loginService)
		.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET,"/api/users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_REGISTERED")
        .antMatchers(HttpMethod.POST,"/api/users/**").anonymous()
        .antMatchers(HttpMethod.DELETE,"/api/users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_REGISTERED")
        .and().httpBasic();

	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/h2/**");
	}
}