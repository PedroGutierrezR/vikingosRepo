package com.vikingo.trazap.app.repository.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "trazabilidad_id_trazabilidad_seq", initialValue = 1, allocationSize = 1, sequenceName = "trazabilidad_id_trazabilidad_seq")
@Entity
public class Trazabilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trazabilidad_id_trazabilidad_seq")
	@Column(name = "id_trazabilidad")
	private int idTrazabilidad;
	private LocalDate fechaInicioPreparacion;
	private LocalDate fechaFinPreparacion;
	private LocalDate fechaEstimadaEnvio;
	private LocalDate fechaEnvio;
	private String codigoTrazabilidad;
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedidos pedidos;
	@ManyToOne
	@JoinColumn(name = "estado_trazabilidad_id")
	private EstadoTrazabilidad estadoTrazabilidad;
	
	@Override
	public String toString() {
		return "Trazabilidad [idTrazabilidad=" + idTrazabilidad + ", fechaInicioPreparacion=" + fechaInicioPreparacion
				+ ", fechaFinPreparacion=" + fechaFinPreparacion + ", fechaEstimadaEnvio=" + fechaEstimadaEnvio
				+ ", fechaEnvio=" + fechaEnvio + ", codigoTrazabilidad=" + codigoTrazabilidad + ", pedidos=" + pedidos
				+ ", estadoTrazabilidad=" + estadoTrazabilidad + "]";
	}

}
