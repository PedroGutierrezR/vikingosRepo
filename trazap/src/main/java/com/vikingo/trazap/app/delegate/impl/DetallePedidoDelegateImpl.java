package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.DetallePedidoDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.DetallePedidoService;
import com.vikingo.trazap.app.service.request.DetallePedidoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("detalleProductoDelegate")
public class DetallePedidoDelegateImpl implements DetallePedidoDelegate {

	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@Override
	public ResponseServiceObject findAll() {
		return detallePedidoService.findAll();
	}

	@Override
	public ResponseServiceObject save(int idDetallePedido, DetallePedidoRequest detallePedidoRequest) {
		return detallePedidoService.save(idDetallePedido, detallePedidoRequest);
	}
	
	@Override
	public ResponseServiceObject save(DetallePedidoRequest detallePedidoRequest) {
		return detallePedidoService.save(detallePedidoRequest);
	}

	@Override
	public ResponseServiceObject findByid(Integer idDetallePedido) throws ServiceException {
		return detallePedidoService.findByid(idDetallePedido);
	}
}
