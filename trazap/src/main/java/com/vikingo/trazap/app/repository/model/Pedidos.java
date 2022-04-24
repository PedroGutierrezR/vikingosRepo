package com.vikingo.trazap.app.repository.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "pedidos_id_seq", initialValue = 1, sequenceName = "pedidos_id_seq", allocationSize = 1)
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_id_seq")
	@Column(name = "id_pedido")
	private int idPedido;
	private LocalDate fecha_ingreso;
	private LocalDate fecha_recibido;
	
	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", fechas_ingreso=" + fecha_ingreso + ",fecha_recibido=" + fecha_recibido +"]";

}
}
