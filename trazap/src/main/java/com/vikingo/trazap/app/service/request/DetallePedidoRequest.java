package com.vikingo.trazap.app.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoRequest {

	private int idDetallePedido;
	private int cantidad;
	private int idProveedorProducto;
}
