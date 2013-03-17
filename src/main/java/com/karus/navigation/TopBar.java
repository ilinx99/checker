package com.karus.navigation;

import com.karus.exam.chooser.ExamChooserView;
import com.karus.fileupload.FileUploadView;
import com.vaadin.server.Page;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.themes.ChameleonTheme;

public class TopBar extends MenuBar {
	private static final long serialVersionUID = 1L;

	private MenuItem takeExam;
	private MenuItem createNewExam;
	
	public TopBar() {
		this.setStyleName(ChameleonTheme.COMPOUND_CSSLAYOUT_TOOLBAR);
		takeExam = this.addItem("Take exam", new TakeExamCommand());
		createNewExam = this.addItem("Create new exam", new CreateNewExamCommand());
	}
	
	private class TakeExamCommand implements Command {
		private static final long serialVersionUID = 1L;

		@Override
		public void menuSelected(MenuItem selectedItem) {
			Page.getCurrent().setFragment("!" + ExamChooserView.NAME);
		}
	}
	
	private class CreateNewExamCommand implements Command {
		private static final long serialVersionUID = 1L;

		@Override
		public void menuSelected(MenuItem selectedItem) {
			Page.getCurrent().setFragment("!" + FileUploadView.NAME);
		}
	}
	
	

}
