package com.vikingo.trazap.app.service.response;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("responseServiceObject")
public class ResponseServiceObject {
	
	private Object body;
	private List<ResponseServiceMessage> messageList;
	
}