package com.vikingos.administracionbodega.request;

import java.time.LocalDate;

import com.vikingos.administracionbodega.repository.model.Bodega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialesRequest {
	
	private int idProducto;
	private int precioProducto;
	private String nombreProducto;
	private LocalDate fechaIngreso;
	private Bodega bodega;
	
}
