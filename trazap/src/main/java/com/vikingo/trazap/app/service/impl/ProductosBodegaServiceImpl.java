package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.ProductosBodegaRepository;
import com.vikingo.trazap.app.repository.model.ProductosBodega;
import com.vikingo.trazap.app.service.ProductosBodegaService;
import com.vikingo.trazap.app.service.request.ProductosBodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Service("productosBodegaService")
public class ProductosBodegaServiceImpl implements ProductosBodegaService {

	@Autowired
	private ProductosBodegaRepository productosBodegaRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<ProductosBodega> productosBodega = new ArrayList<ProductosBodega>();
		
		Iterable<ProductosBodega> iterableProductosBodega = productosBodegaRepository.findAll();
		
		iterableProductosBodega.forEach(productosBodega::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(productosBodega);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		ProductosBodega productosBodega = new ProductosBodega();
	//	productosBodega.setProducto(productosBodegaRequest.getIdProducto());
		productosBodega.setStock(productosBodegaRequest.getStock());
		
		
		
		responseServiceObject.setBody(productosBodegaRepository.save(productosBodega));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(int idProductoBodega, ProductosBodegaRequest productosBodegaRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		ProductosBodega productosBodega = new ProductosBodega();
		productosBodega.setIdProductoBodega(idProductoBodega);
	//	productosBodega.setProducto(productosBodegaRequest.getIdProducto());
		productosBodega.setStock(productosBodegaRequest.getStock());
		
		responseServiceObject.setBody(productosBodegaRepository.save(productosBodega));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findByid(Integer idProductoBodega) throws ServiceException {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			ProductosBodega productosBodega = productosBodegaRepository.findById(idProductoBodega).get();
			
			responseServiceObject.setBody(productosBodega);
			
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
	
}
