package com.karus.exam.persistence;

import java.util.List;

public interface ExamDao {
	void save(Exam exam);

	List<Exam> getExams();

	Exam findExamByName(String examName);
}
