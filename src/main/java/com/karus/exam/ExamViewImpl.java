package com.karus.exam;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.karus.domain.DictionaryEntry;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

@Component
@VaadinView(ExamView.NAME)
public class ExamViewImpl extends HorizontalLayout implements ExamView {
	private static final long serialVersionUID = 1L;

	private VerticalLayout inputAndTableLayout;
	
	@Autowired
	private ExamIntroductionPanel introPanel;
	
	@Autowired
	private ExamResultPanel resultPanel;
	
	@Autowired
	private AnswerInputPanel answerInputPanel;
	
	@Autowired
	private ResultTable resultTable;

	@Override
	public void enter(ViewChangeEvent event) {
	}

	@PostConstruct
	public void build() {
		this.setStyleName(ChameleonTheme.PANEL_BUBBLE);
		this.setWidth("100%");
		inputAndTableLayout = new VerticalLayout();
		addComponent(introPanel);
	}

	@Override
	public void addStartListener(ClickListener listener) {
		introPanel.addStartListener(listener);
	}

	@Override
	public void startExam() {
		removeComponent(introPanel);
		
		inputAndTableLayout.addComponent(answerInputPanel);
		inputAndTableLayout.addComponent(resultTable);
		addComponent(inputAndTableLayout);
		addComponent(resultPanel);
	}
	
	@Override
	public void setFirstQuestion(DictionaryEntry dictEntry, int totalElementCount) {
		answerInputPanel.setWordsToTranslate(dictEntry.getPolWords());
		resultPanel.setTotalCount(totalElementCount);
	}

	@Override
	public void addNextAnswerClickListener(ClickListener listener) {
		answerInputPanel.addNextAnswerClickListener(listener);
		
	}

	@Override
	public String getAnswer() {
		return answerInputPanel.getAnswer();
	}

	@Override
	public void doAnswer(LastAnswerModel model) {
		resultPanel.doAnswer(model);
		resultTable.addAnswerRow(model);
	}

	@Override
	public void updateNextQuestion(DictionaryEntry lastEntry) {
		answerInputPanel.setWordsToTranslate(lastEntry.getPolWords());
	}

	@Override
	public void endExam() {
		answerInputPanel.endExam();
		String percentage = resultPanel.getPercentage();
		Notification.show("You have completed the exam with score = " + percentage +"%");
	}

	@Override
	public void addResetClickListener(ClickListener resetClickListener) {
		answerInputPanel.addResetClickListener(resetClickListener);
	}

	@Override
	public void reset() {
		answerInputPanel.reset();
		resultTable.reset();
		resultPanel.reset();
	}

	@Override
	public void addChangeExamClickListener(ClickListener changeExamClickListener) {
		answerInputPanel.addChangeExamClickListener(changeExamClickListener);
	}
}