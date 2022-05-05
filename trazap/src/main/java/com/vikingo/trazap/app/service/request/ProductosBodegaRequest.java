package com.vikingo.trazap.app.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosBodegaRequest {

	private int idProductoBodega;
	private int idProducto;
	private int idBodega;
	private int stock; 
	
}
