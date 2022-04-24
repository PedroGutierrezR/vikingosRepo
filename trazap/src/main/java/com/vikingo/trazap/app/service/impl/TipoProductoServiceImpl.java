package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.repository.TipoProductoRepository;
import com.vikingo.trazap.app.repository.model.TipoProducto;
import com.vikingo.trazap.app.service.TipoProductoService;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Service("tipoProductoSevice")
public class TipoProductoServiceImpl implements TipoProductoService {

	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<TipoProducto> tipoProductosList = new ArrayList<TipoProducto>();
		
		Iterable<TipoProducto> iterableTipoProducto = tipoProductoRepository.findAll();
		
		iterableTipoProducto.forEach(tipoProductosList::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(tipoProductosList);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject save(TipoProducto tipoProducto) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(tipoProductoRepository.save(tipoProducto));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	
}
