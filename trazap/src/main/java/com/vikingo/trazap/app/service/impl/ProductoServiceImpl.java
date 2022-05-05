package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.ProductoRepository;
import com.vikingo.trazap.app.repository.model.Producto;
import com.vikingo.trazap.app.service.ProductoService;
import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;

	@Override
	public ResponseServiceObject findAll() {

		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Producto> productos = new ArrayList<Producto>();

		Iterable<Producto> iterableProductos = productoRepository.findAll();

		iterableProductos.forEach(productos::add);

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setBody(productos);
		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(ProductoRequest productoRequest) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();

		Producto producto = new Producto();
		producto.setDescripcion(productoRequest.getDescripcion());

		responseServiceObject.setBody(productoRepository.save(producto));

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(int idProducto, ProductoRequest productoRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		producto.setDescripcion(productoRequest.getDescripcion());

		responseServiceObject.setBody(productoRepository.save(producto));

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(ProductoRequest productoRequest) {
		productoRepository.deleteById(productoRequest.getIdProducto());
	}

}
