package com.karus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karus.dao.LoginDao;
import com.karus.entity.Login;


@Service
public class LoginServiceImpl {
	@Autowired 
	private LoginDao loginDao;
	
	@Transactional
	public List<Login> getLogins(){
		return loginDao.getLogins();
	}
	
}
