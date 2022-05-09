package com.vikingo.trazap.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	private int cantidad;
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPedido")
	@JsonIdentityReference(alwaysAsId = true)
	private Pedidos pedidos;
	@ManyToOne
	@JoinColumn(name = "proveedor_producto_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProductoPoveedor")
	@JsonIdentityReference(alwaysAsId = true)
	private ProductoProveedor productoProveedor;
	
	@Override
	public String toString() {
		return "DetallePedido [idDetallePedido=" + idDetallePedido + ", pedidos=" + pedidos + ", cantidad=" + cantidad
				+ ", productoProveedor=" + productoProveedor + "]";
	}
	
}
