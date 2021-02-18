package com.valterApolinario.apiRest.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final JwtTokenProvider tokenProvider;
	
	
	@Override
	public void configure (HttpSecurity httpSecurity) throws Exception{
		JwtTokenFilter customFilter = new JwtTokenFilter(tokenProvider);
		httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
