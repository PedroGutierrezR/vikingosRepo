package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.Pedidos;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface PedidosDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Pedidos pedidos);
}
