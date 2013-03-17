package com.karus.exam.persistence;

import java.util.List;

import com.karus.entries.DictionaryEntriesModel;

public interface ExamService {

	void save(DictionaryEntriesModel model);

	List<String> getExamNames();

	DictionaryEntriesModel getDictEntriesByName(String examName);
}
