package com.vikingo.trazap.app.service.request;

import com.vikingo.trazap.app.repository.model.ProductoProveedor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorRequest {

	private int idProveedor;
	private String rutProveedor;
	private String razonSocial;
	private ProductoProveedor prodcutoProveedor;
}
