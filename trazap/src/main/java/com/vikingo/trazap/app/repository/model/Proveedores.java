package com.vikingo.trazap.app.repository.model;

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
@SequenceGenerator(name = "proveedores_id_seq", initialValue = 1, sequenceName = "proveedores_id_seq", allocationSize = 1)
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedores_id_seq")
	@Column(name = "id_proveedor")
	private int idPoveedor;
	private String rut_proveedor;
	private String razon_social;
}
