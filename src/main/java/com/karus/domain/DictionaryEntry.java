package com.karus.domain;

import java.util.List;

import com.google.common.collect.Lists;

public class DictionaryEntry {
	private List<String> engWords;
	private List<String> polWords;

	public DictionaryEntry(String engWord, String polWord) {
		this.engWords = Lists.newArrayList(engWord);
		this.polWords = Lists.newArrayList(polWord);
	}
	
	public DictionaryEntry(List<String> engWords, List<String> polWords) {
		this.engWords = engWords;
		this.polWords = polWords;
	}

	public List<String> getEngWords() {
		return engWords;
	}

	public void setEngWords(List<String> engWords) {
		this.engWords = engWords;
	}

	public List<String> getPolWords() {
		return polWords;
	}

	public void setPolWords(List<String> polWords) {
		this.polWords = polWords;
	}
}
