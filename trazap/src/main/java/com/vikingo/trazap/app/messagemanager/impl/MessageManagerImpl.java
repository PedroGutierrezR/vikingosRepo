package com.vikingo.trazap.app.messagemanager.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import com.vikingo.trazap.app.messagemanager.MessageManager;

@Component("messageManager")
public class MessageManagerImpl implements MessageManager {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public String getRosourceMessageKey(String key) {
		return messageSource.getMessage(key, null, new Locale("CL"));
	}

}
