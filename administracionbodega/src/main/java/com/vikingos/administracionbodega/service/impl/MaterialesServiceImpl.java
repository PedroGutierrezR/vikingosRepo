package com.vikingos.administracionbodega.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.repository.BodegaRepository;
import com.vikingos.administracionbodega.repository.MaterialesRepository;
import com.vikingos.administracionbodega.repository.model.Bodega;
import com.vikingos.administracionbodega.repository.model.Materiales;
import com.vikingos.administracionbodega.request.MaterialesRequest;
import com.vikingos.administracionbodega.service.MaterialesService;
import com.vikingos.administracionbodega.service.response.ResponseServiceMessage;
import com.vikingos.administracionbodega.service.response.ResponseServiceMessageType;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

@Service("materialesService")
public class MaterialesServiceImpl implements MaterialesService {

	@Autowired
	private MaterialesRepository materialesRepository;
	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Materiales> materiales = new ArrayList<Materiales>();
		
		Iterable<Materiales> iterableMateriales = materialesRepository.findAll();
		
		iterableMateriales.forEach(materiales::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(materiales);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(MaterialesRequest materialesRequest) {
		
		Materiales material = new Materiales();
		material.setNombreProducto(materialesRequest.getNombreProducto());
		material.setPrecioProducto(materialesRequest.getPrecioProducto());
		material.setFechaIngreso(materialesRequest.getFechaIngreso());
	
		List<Bodega> bodegas = new ArrayList<Bodega>();
		Iterable<Bodega> iterableBodegas = bodegaRepository.findAll();
		iterableBodegas.forEach(bodegas::add);
		
		for (Bodega bodega : bodegas) {
			if(bodega.getIdBodega() == materialesRequest.getBodega().getIdBodega()) {
				material.setBodega(bodega);
			}
		}
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(materialesRepository.save(material));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(int idProducto, MaterialesRequest materialesRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		Materiales material = new Materiales();
		material.setIdProducto(idProducto);
		material.setNombreProducto(materialesRequest.getNombreProducto());
		material.setPrecioProducto(materialesRequest.getPrecioProducto());
		material.setFechaIngreso(materialesRequest.getFechaIngreso());
	
		List<Bodega> bodegas = new ArrayList<Bodega>();
		Iterable<Bodega> iterableBodegas = bodegaRepository.findAll();
		iterableBodegas.forEach(bodegas::add);
		
		for (Bodega bodega : bodegas) {
			if(bodega.getIdBodega() == materialesRequest.getBodega().getIdBodega()) {
				material.setBodega(bodega);
			}
		}

		responseServiceObject.setBody(materialesRepository.save(material));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Materiales materiales = materialesRepository.findById(idProducto).get();
			
			responseServiceObject.setBody(materiales);
			
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

	@Override
	public void deleteById(MaterialesRequest materialesRequest) {
		materialesRepository.deleteById(materialesRequest.getIdProducto());
	}

}
