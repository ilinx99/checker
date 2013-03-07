package com.karus.exam.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoImpl implements ExamDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Exam exam) {
		 getSession().save(exam);
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
