package com.vikingo.trazap.app.service.response;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("responseServiceMessage")
public class ResponseServiceMessage {
	
	private Date timestamp;
	private String code;
	private ResponseServiceMessageType type;
	private String message;
	
}
