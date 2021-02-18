package com.valterApolinario.apiRest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.valterApolinario.apiRest.dao.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

	final UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userDao.findByUserName(username);
		if(user!= null) {
			return user;
		}else {
			throw new UsernameNotFoundException("username" +
		" " + username + " " + "Não encontrado");
		}
	}
}
