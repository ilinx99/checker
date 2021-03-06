package com.karus.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SpringSecurityHelper {
	public static boolean hasRole(String role) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getAuthorities().contains(new SimpleGrantedAuthority(role));
	}
}
