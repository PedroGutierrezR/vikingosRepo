package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.repository.TrazabilidadRepository;
import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.TrazabilidadService;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;



@Service("trazabilidadService")
public class TrazabilidadServiceImpl implements TrazabilidadService{

	@Autowired
	private TrazabilidadRepository trazabilidadRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Trazabilidad> trazabilidadList = new ArrayList<Trazabilidad>();
		
		Iterable<Trazabilidad> iterableTrazabilidad = trazabilidadRepository.findAll();
		
		iterableTrazabilidad.forEach(trazabilidadList::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(trazabilidadList);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject save(Trazabilidad trazabilidad) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(trazabilidadRepository.save(trazabilidad));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}
}
