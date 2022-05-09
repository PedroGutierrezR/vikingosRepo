package com.vikingo.trazap.app.service.response.producto;

import java.util.List;

import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.repository.model.ProductoProveedor;
import com.vikingo.trazap.app.repository.model.ProductosBodega;
import com.vikingo.trazap.app.repository.model.TipoProducto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {

	private int idProducto;
	private String descripcion;
	private CategoriaProducto categoriaProducto;
	private TipoProducto tipoProducto;
	private List<ProductosBodega> productosBodegas;
	private List<ProductoProveedor> productoProveedorList;
	
}
