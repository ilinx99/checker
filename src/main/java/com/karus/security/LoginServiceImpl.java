package com.karus.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karus.security.persistance.Login;
import com.karus.security.persistance.LoginDao;


@Service
public class LoginServiceImpl {
	@Autowired 
	private LoginDao loginDao;
	
	@Transactional
	public List<Login> getLogins(){
		return loginDao.getLogins();
	}
	
}
