package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vikingo.trazap.app.delegate.PedidosDelegate;
import com.vikingo.trazap.app.repository.model.Pedidos;
import com.vikingo.trazap.app.service.PedidosService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public class PedidosDelegateImpl implements PedidosDelegate {

	@Autowired
	private PedidosService pedidosService;
	
	@Override
	public ResponseServiceObject findAll() {
		return pedidosService.findAll();
	}

	@Override
	public ResponseServiceObject save(Pedidos pedidos) {
		return pedidosService.save(pedidos);
	}

}
