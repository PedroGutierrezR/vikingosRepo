package com.vikingo.trazap.app.repository.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "proveedores_id_seq", initialValue = 1, sequenceName = "proveedores_id_seq", allocationSize = 1)
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedores_id_seq")
	@Column(name = "id_proveedor")
	private int idPoveedor;
	private String rut_proveedor;
	private String razon_social;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "proveedor_id")
	private List<ProductoProveedor> productoProveedores;
	
}
