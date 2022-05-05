package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.DetallePedidoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface DetallePedidoService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idDetallePedido, DetallePedidoRequest detallePedidoRequest);
	public ResponseServiceObject save(DetallePedidoRequest detallePedidoRequest);
	public ResponseServiceObject findByid(Integer idDetallePedido) throws ServiceException;
	
}
