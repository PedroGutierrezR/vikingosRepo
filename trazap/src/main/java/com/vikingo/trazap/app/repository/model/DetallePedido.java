package com.vikingo.trazap.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "detalle_pedido_id_seq", initialValue = 1, sequenceName = "detalle_pedido_id_seq", allocationSize = 1)
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_pedido_id_seq")
	@Column(name = "id_detalle_pedido")
	private int idDetallePedido;
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedidos pedidos;
	private int cantidad;
	
}
