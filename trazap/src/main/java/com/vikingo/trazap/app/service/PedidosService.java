package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.Pedidos;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface PedidosService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Pedidos pedidos);
}
