package com.karus.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karus.entries.DictionaryEntriesModel;
import com.karus.exam.persistence.Exam;
import com.karus.exam.persistence.ExamDao;

@Service
public class ExamServiceImpl implements ExamService {
	@Autowired
	private EntriesModelConverter converter;
	
	@Autowired
	private ExamDao examDao;
	
	@Override
	@Transactional
	public void save(DictionaryEntriesModel model) {
		Exam exam = converter.toExam(model);
		examDao.save(exam);
	}

}
