package com.karus.exam;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.google.gwt.thirdparty.guava.common.collect.Sets;
import com.karus.domain.DictionaryEntry;
import com.karus.entries.DictionaryEntriesModel;
import com.karus.exam.persistence.Exam;
import com.karus.exam.persistence.ExamEntry;
import com.karus.exam.persistence.Lang;
import com.karus.exam.persistence.Word;

@Component
public class EntriesModelConverter {

	public Exam toExam(DictionaryEntriesModel model) {
		Exam exam = new Exam();
		exam.setName(model.getExamName());
		
		Set<ExamEntry> examEntries = createEntries(model.getEntries());
		exam.setEntries(examEntries);
		
		return exam;
	}

	private Set<ExamEntry> createEntries(List<DictionaryEntry> entries) {
		Set<ExamEntry> examEntries = Sets.newHashSet();
		
		for (DictionaryEntry dictEntry : entries) {
			ExamEntry examEntry = new ExamEntry();
			examEntry.setWords(toWords(dictEntry));
			
			examEntries.add(examEntry);
		}
		
		return examEntries;
	}

	private Set<Word> toWords(DictionaryEntry dictEntry) {
		Set<Word> polWords = toLangWords(dictEntry.getPolWords(), Lang.POL);
		Set<Word> engWords = toLangWords(dictEntry.getEngWords(), Lang.ENG);
		
		polWords.addAll(engWords);
		
		return polWords;
	}

	private Set<Word> toLangWords(List<String> textWords, Lang lang) {
		Set<Word> words = Sets.newHashSet();
		
		for (String text : textWords) {
			Word word = new Word();
			word.setLang(lang);
			word.setText(text);
			
			words.add(word);
		}
		
		return words;
	}

}
