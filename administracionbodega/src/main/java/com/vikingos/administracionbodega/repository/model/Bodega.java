package com.vikingos.administracionbodega.repository.model;

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
@SequenceGenerator(name = "bodega_id_seq", initialValue = 1, sequenceName = "bodega_id_seq", allocationSize = 1)
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bodega_id_seq")
	@Column(name = "id_bodega")
	private int idBodega;
	private String nombre_bodega;
	private LocalDate fecha_ingreso;
}
