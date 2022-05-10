package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.CategoriaProductoRepository;
import com.vikingo.trazap.app.repository.ProductoRepository;
import com.vikingo.trazap.app.repository.TipoProductoRepository;
import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.repository.model.Producto;
import com.vikingo.trazap.app.repository.model.TipoProducto;
import com.vikingo.trazap.app.service.ProductoService;
import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;
import com.vikingo.trazap.app.service.response.producto.ProductoResponse;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;

	@Override
	public ResponseServiceObject findAll() {
	
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		//Productos
		List<Producto> productos = new ArrayList<Producto>();
		Iterable<Producto> iterableProductos = productoRepository.findAll();
		iterableProductos.forEach(productos::add);
		//set a productoResponse
		List<ProductoResponse> response = new ArrayList<ProductoResponse>();
		for(Producto producto: productos) {
			ProductoResponse productoResponse = new ProductoResponse();
			productoResponse.setIdProducto(producto.getIdProducto());
			productoResponse.setDescripcion(producto.getDescripcion());
			productoResponse.setCategoriaProducto(producto.getCategoriaProducto());
			productoResponse.setProductoProveedorList(producto.getProductoProveedorList());
			productoResponse.setProductosBodegas(producto.getProductosBodegas());
			productoResponse.setTipoProducto(producto.getTipoProducto());
			response.add(productoResponse);
		}
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setBody(response);
		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(ProductoRequest productoRequest) {
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();

		Producto producto = new Producto();
		producto.setDescripcion(productoRequest.getDescripcion());
		
		List<TipoProducto> tipoProductos = new ArrayList<TipoProducto>();
		Iterable<TipoProducto> iterableTipoProducto = tipoProductoRepository.findAll();
		iterableTipoProducto.forEach(tipoProductos::add);
		
		for (TipoProducto tipoProducto : tipoProductos) {
			if(tipoProducto.getIdTipoProducto() == productoRequest.getTipoProducto().getIdTipoProducto()) {
				producto.setTipoProducto(tipoProducto);
			}
		}
		
		List<CategoriaProducto> categoriaProductos = new ArrayList<CategoriaProducto>();
		Iterable<CategoriaProducto> iterableCategoriaProducto = categoriaProductoRepository.findAll();
		iterableCategoriaProducto.forEach(categoriaProductos::add);
		
		for (CategoriaProducto categoriaProducto : categoriaProductos) {
			if(categoriaProducto.getIdCategoriaProducto() == productoRequest.getCategoriaProducto().getIdCategoriaProducto()) {
				producto.setCategoriaProducto(categoriaProducto);
			}
		}
		
		productoRepository.save(producto);
		
		//Productos
		List<Producto> productos = new ArrayList<Producto>();
		Iterable<Producto> iterableProductos = productoRepository.findAll();
		iterableProductos.forEach(productos::add);
		//set a productoResponse
		List<ProductoResponse> response = new ArrayList<ProductoResponse>();
		for(Producto iProducto: productos) {
			ProductoResponse productoResponse = new ProductoResponse();
			productoResponse.setIdProducto(iProducto.getIdProducto());
			productoResponse.setDescripcion(iProducto.getDescripcion());
			productoResponse.setCategoriaProducto(iProducto.getCategoriaProducto());
			productoResponse.setProductoProveedorList(iProducto.getProductoProveedorList());
			productoResponse.setProductosBodegas(iProducto.getProductosBodegas());
			productoResponse.setTipoProducto(iProducto.getTipoProducto());
			response.add(productoResponse);
		}
		
		responseServiceObject.setBody(response);

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
		
		List<TipoProducto> tipoProductos = new ArrayList<TipoProducto>();
		Iterable<TipoProducto> iterableTipoProducto = tipoProductoRepository.findAll();
		iterableTipoProducto.forEach(tipoProductos::add);
		
		for (TipoProducto tipoProducto : tipoProductos) {
			if(tipoProducto.getIdTipoProducto() == productoRequest.getTipoProducto().getIdTipoProducto()) {
				producto.setTipoProducto(tipoProducto);
			}
		}
		
		List<CategoriaProducto> categoriaProductos = new ArrayList<CategoriaProducto>();
		Iterable<CategoriaProducto> iterableCategoriaProducto = categoriaProductoRepository.findAll();
		iterableCategoriaProducto.forEach(categoriaProductos::add);
		
		for (CategoriaProducto categoriaProducto : categoriaProductos) {
			if(categoriaProducto.getIdCategoriaProducto() == productoRequest.getCategoriaProducto().getIdCategoriaProducto()) {
				producto.setCategoriaProducto(categoriaProducto);
			}
		}
		
		productoRepository.save(producto);
		
		//Productos
		List<Producto> productos = new ArrayList<Producto>();
		Iterable<Producto> iterableProductos = productoRepository.findAll();
		iterableProductos.forEach(productos::add);
		//set a productoResponse
		List<ProductoResponse> response = new ArrayList<ProductoResponse>();
		for(Producto iProducto: productos) {
			ProductoResponse productoResponse = new ProductoResponse();
			productoResponse.setIdProducto(iProducto.getIdProducto());
			productoResponse.setDescripcion(iProducto.getDescripcion());
			productoResponse.setCategoriaProducto(iProducto.getCategoriaProducto());
			productoResponse.setProductoProveedorList(iProducto.getProductoProveedorList());
			productoResponse.setProductosBodegas(iProducto.getProductosBodegas());
			productoResponse.setTipoProducto(iProducto.getTipoProducto());
			response.add(productoResponse);
		}
		
		responseServiceObject.setBody(response);

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
	public ResponseServiceObject deleteById(ProductoRequest productoRequest) {
		
		productoRepository.deleteById(productoRequest.getIdProducto());
		
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		//Productos
		List<Producto> productos = new ArrayList<Producto>();
		Iterable<Producto> iterableProductos = productoRepository.findAll();
		iterableProductos.forEach(productos::add);
		//set a productoResponse
		List<ProductoResponse> response = new ArrayList<ProductoResponse>();
		for(Producto iProducto: productos) {
			ProductoResponse productoResponse = new ProductoResponse();
			productoResponse.setIdProducto(iProducto.getIdProducto());
			productoResponse.setDescripcion(iProducto.getDescripcion());
			productoResponse.setCategoriaProducto(iProducto.getCategoriaProducto());
			productoResponse.setProductoProveedorList(iProducto.getProductoProveedorList());
			productoResponse.setProductosBodegas(iProducto.getProductosBodegas());
			productoResponse.setTipoProducto(iProducto.getTipoProducto());
			response.add(productoResponse);
		}
		
		responseServiceObject.setBody(response);

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

}
