package com.vikingo.trazap.app.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "producto_proveedor_id_seq", initialValue = 1, sequenceName = "producto_proveedor_id_seq", allocationSize = 1)
public class ProductoProveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_proveedor_id_seq")
	@Column(name = "id_producto_proveedor")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_proveedor_id")
	private int idProductoPoveedor;
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private int idProveedor;
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private int idProducto;
	
}
