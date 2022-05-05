package com.vikingo.trazap.app.service.request;

import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.repository.model.TipoProducto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

	private Integer idProducto;
	private String descripcion;
	private CategoriaProducto categoriaProducto;
	private TipoProducto tipoProducto;
	
}
