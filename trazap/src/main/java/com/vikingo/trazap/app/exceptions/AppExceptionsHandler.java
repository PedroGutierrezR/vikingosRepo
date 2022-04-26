package com.vikingo.trazap.app.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

//Clase que está escuchando las excepciones y las maneja
@ControllerAdvice
public class AppExceptionsHandler {

	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlerException(Exception ex, WebRequest request){
		return new ResponseEntity<Object>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handlerException(NoSuchElementException ex, WebRequest request){
		return new ResponseEntity<Object>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ResponseServiceObject> handlerServiceException(ServiceException ex, WebRequest request){
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(null);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode((String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())));
		responseServiceMessage.setType(ResponseServiceMessageType.ERROR);
		responseServiceMessage.setMessage(ex.getMessage());
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return new ResponseEntity<ResponseServiceObject>(responseServiceObject, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
