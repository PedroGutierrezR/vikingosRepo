package com.vikingos.administracionbodega.repository.model;

import java.time.LocalDate;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "producto_id_seq", initialValue = 1, sequenceName = "producto_id_seq", allocationSize = 1)
public class Materiales {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_seq")
	@Column(name = "id_producto")
	private int idProducto;
	private int precioProducto;
	private String nombreProducto;
	private LocalDate fechaIngreso;
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombreBodega")
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
	@JoinColumn(name = "bodega_id")
	private Bodega bodega;

	@Override
	public String toString() {
		return "Materiales [idProducto=" + idProducto + ", precioProducto=" + precioProducto + ", nombreProducto="
				+ nombreProducto + ", fechaIngreso=" + fechaIngreso + ", bodega=" + bodega + "]";
	}

}
