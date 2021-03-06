package com.karus.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karus.security.persistance.Login;
import com.karus.security.persistance.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	
	@Override
	@Transactional
	public List<Login> getLogins() {
		return loginDao.getLogins();
	}

	@Override
	@Transactional
	public void updatePassword(String name, String pass) {
		loginDao.updatePassword(name, pass);
	}

}
