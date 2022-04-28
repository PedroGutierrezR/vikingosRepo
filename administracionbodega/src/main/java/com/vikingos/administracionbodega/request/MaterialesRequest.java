package com.vikingos.administracionbodega.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialesRequest {
	
	public int precio_producto;
	public String nombre_producto;
}
