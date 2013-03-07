package com.karus.security;

import java.util.List;

import com.karus.security.persistance.Login;

public interface LoginService {
	List<Login> getLogins();
	void updatePassword(String name, String pass);
}
