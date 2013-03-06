package com.karus.entries;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.karus.domain.BadEntryParseException;
import com.karus.domain.DictionaryEntry;
import com.karus.entity.Login;
import com.karus.service.LoginServiceImpl;

@Component
public class DictionartEntriesModel {
	private static final String ENTRY_SEPARATOR = ",";
	private static final String POL_ENG_SEPARATOR = "-";
	
	@Autowired
	private LoginServiceImpl loginService;

	private List<DictionaryEntry> entries = Lists.newArrayList();
	private Iterator<DictionaryEntry> entriesIterator;
	
	public void parseLine(String strLine) throws BadEntryParseException {
		List<Login> logins = loginService.getLogins();
		String[] polEngEntries = strLine.split(POL_ENG_SEPARATOR);
		if (polEngEntries.length != 2) {
			throw new BadEntryParseException("Missing or too many separators");
		}

		String polEntries = polEngEntries[0].trim();
		String engEntries = polEngEntries[1].trim();

		DictionaryEntry dictEntry = new DictionaryEntry(createListOfEntries(engEntries),
				createListOfEntries(polEntries));
		entries.add(dictEntry);
	}

	private List<String> createListOfEntries(String entries) throws BadEntryParseException {
		String[] entriesTab = entries.split(ENTRY_SEPARATOR);
		if (entriesTab.length == 0) {
			throw new BadEntryParseException("No entries for specified language");
		}

		return Lists.newArrayList(entriesTab);
	}
	
	public void shuffle(){
		Collections.shuffle(entries);
		entriesIterator = entries.iterator();
	}
	
	public DictionaryEntry next(){
		if (entriesIterator == null){
			shuffle();
		}
		
		if (!entriesIterator.hasNext()) {
			return null;
		}

		return entriesIterator.next();
	}
	
	public int size(){
		return entries.size();
	}

	public void clear() {
		entries = Lists.newArrayList();
		entriesIterator = null; 
	}

	public List<DictionaryEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<DictionaryEntry> entries) {
		this.entries = entries;
	}
}
