package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.ProveedorRepository;
//7import com.vikingo.trazap.app.repository.model.Producto;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.ProveedorService;
//import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.request.ProveedorRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Service("proveedorService")
public class ProveedoresServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository proveedorRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Proveedor> proveedoresList = new ArrayList<Proveedor>();
		
		Iterable<Proveedor> iterableProveedores = proveedorRepository.findAll();
		
		iterableProveedores.forEach(proveedoresList::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(proveedoresList);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject save(Proveedor proveedores) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(proveedorRepository.save(proveedores));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject save(int idProveedor, ProveedorRequest proveedorRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Proveedor proveedor = new Proveedor();
		proveedor.setRut_proveedor(proveedorRequest.getRutProveedor());
		proveedor.setRazon_social(proveedorRequest.getRazonSocial());

		responseServiceObject.setBody(proveedorRepository.save(proveedor));

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findByid(Integer idProveedor) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(ProveedorRequest proveedorRequest) {
		proveedorRepository.deleteById(proveedorRequest.getIdProveedor());
	}
}