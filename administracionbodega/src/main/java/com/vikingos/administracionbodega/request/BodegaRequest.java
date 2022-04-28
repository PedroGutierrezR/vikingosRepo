package com.vikingos.administracionbodega.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodegaRequest {

	private String nombre_bodega;
	private LocalDate fecha_ingreso;
	
}
