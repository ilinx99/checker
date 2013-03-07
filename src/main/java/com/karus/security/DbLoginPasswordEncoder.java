package com.karus.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.karus.security.persistance.Login;

public class DbLoginPasswordEncoder {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SaltSource saltSource;
	
	@Autowired
	private LoginService loginService;
	
	public void encodePasswords(){
		List<Login> logins = loginService.getLogins();
		
		List<UserDetails> users = Lists.transform(logins, new LoginToUserDetails());
		encodeUsers(users);
		
	}
	
	private void encodeUsers(List<UserDetails> users) {
		for (UserDetails user : users) {
			String password = user.getPassword();
			Object salt = saltSource.getSalt(user);
			String username = user.getUsername();
			
			String encodedPassword = passwordEncoder.encodePassword(password, salt);
			loginService.updatePassword(username, encodedPassword);
		}
	}
	
	private class LoginToUserDetails implements Function<Login, UserDetails> {
		public UserDetails apply(Login login) {
			User user = new UserBuilder().setLogin(login).build();
			return user;
		}
	}

}
