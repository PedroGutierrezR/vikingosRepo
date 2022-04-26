package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.messagemanager.MessageManager;
import com.vikingo.trazap.app.model.request.BodegaRequest;
import com.vikingo.trazap.app.repository.BodegaRepository;
import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.service.BodegaService;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Service("bodegaService")
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Autowired
	private MessageManager messageManager;
	
	@Override
	public ResponseServiceObject findAll() {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Bodega> bodegas = new ArrayList<Bodega>();
		
		Iterable<Bodega> iterableBodegas = bodegaRepository.findAll();
		
		iterableBodegas.forEach(bodegas::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(bodegas);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(BodegaRequest bodegaRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		Bodega bodega = new Bodega();
		bodega.setDescripcion(bodegaRequest.getDescripcion());
		
		responseServiceObject.setBody(bodegaRepository.save(bodega));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		Bodega bodega = new Bodega();
		bodega.setIdBodega(idBodega);
		bodega.setDescripcion(bodegaRequest.getDescripcion());
		
		responseServiceObject.setBody(bodegaRepository.save(bodega));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode(messageManager.getRosourceMessageKey("com.vikingo.message.CREATED.code"));// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage(messageManager.getRosourceMessageKey("com.vikingo.message.CREATED.desc"));
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Bodega bodega = bodegaRepository.findById(idBodega).get();
			
			responseServiceObject.setBody(bodega);
			
			responseServiceMessage.setTimestamp(new Date());
			responseServiceMessage.setCode(messageManager.getRosourceMessageKey("com.vikingo.message.OK.code"));// 201 = create ok
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage(messageManager.getRosourceMessageKey("com.vikingo.message.OK.desc"));
			
			messageList.add(responseServiceMessage);
			
			responseServiceObject.setMessageList(messageList);
			
			return responseServiceObject;
		} catch (NoSuchElementException e) {
			throw new ServiceException("No existen registros");	
		} catch (Exception e) {
			throw new ServiceException("Error en el servicio");
		}

	}
		
}
