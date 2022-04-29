package com.vikingos.administracionbodega.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodegaRequest {

	private Integer idBodega;
	private String nombreBodega;
	private LocalDate fechaIngreso;
	
}
