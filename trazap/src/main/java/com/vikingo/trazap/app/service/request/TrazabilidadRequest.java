package com.vikingo.trazap.app.service.request;

import java.time.LocalDate;

import com.vikingo.trazap.app.repository.model.EstadoTrazabilidad;
import com.vikingo.trazap.app.repository.model.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrazabilidadRequest {

	private int idTrazabilidad;
	private LocalDate fechaInicioPreparacion;
	private LocalDate fechaFinPreparacion;
	private LocalDate fechaEstimadaEnvio;
	private LocalDate fechaEnvio;
	private String codigoTrazabilidad;
	private Pedidos pedidos;
	private EstadoTrazabilidad estadoTrazabilidad;
}
