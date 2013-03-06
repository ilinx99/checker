package com.karus.fileupload;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@VaadinView(FileUploadView.NAME)
public class FileUploadViewImpl extends VerticalLayout implements FileUploadView {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FileUploadPanel panel;
	
	@Autowired
	private FileUploadComponent upload;
	
	@PostConstruct
	public void build() {
		panel.addComponent(upload);
		addComponent(panel);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void addReceiver(Receiver receiver) {
		upload.setReceiver(receiver);
	}

	@Override
	public void addSuccedListener(SucceededListener listener) {
		upload.addSucceededListener(listener);
	}
}
