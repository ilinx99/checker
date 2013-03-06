package com.karus.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karus.entity.Login;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Login> getLogins() {
		List<Login> logins = getSession().createQuery("from Login").list();

		return logins;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
