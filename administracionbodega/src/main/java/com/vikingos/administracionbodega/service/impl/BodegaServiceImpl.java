package com.vikingos.administracionbodega.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.repository.BodegaRepository;
import com.vikingos.administracionbodega.repository.model.Bodega;
import com.vikingos.administracionbodega.request.BodegaRequest;
import com.vikingos.administracionbodega.service.BodegaService;
import com.vikingos.administracionbodega.service.response.ResponseServiceMessage;
import com.vikingos.administracionbodega.service.response.ResponseServiceMessageType;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

@Service("bodegaService")
public class BodegaServiceImpl implements BodegaService{

	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	
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
		bodega.setNombre_bodega(bodegaRequest.getNombre_bodega());
		bodega.setFecha_ingreso(bodegaRequest.getFecha_ingreso());
		
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
		bodega.setNombre_bodega(bodegaRequest.getNombre_bodega());
		bodega.setFecha_ingreso(bodegaRequest.getFecha_ingreso());

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
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Bodega bodega = bodegaRepository.findById(idBodega).get();
			
			responseServiceObject.setBody(bodega);
			
			responseServiceMessage.setTimestamp(new Date());
			responseServiceMessage.setCode("200");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
			
			messageList.add(responseServiceMessage);
			
			responseServiceObject.setMessageList(messageList);
			
			return responseServiceObject;
		} catch (NoSuchElementException e) {
			throw new ServiceException("No existen registros");	
		} catch (Exception e) {
			throw new ServiceException("Error en el servicio");
		}

	}
//no funciona, arreglar
	@Override
	public void deleteById(BodegaRequest bodegaRequest) {
		System.out.println(bodegaRequest.getIdBodega());
		bodegaRepository.deleteById(bodegaRequest.getIdBodega());
	
	}
}
