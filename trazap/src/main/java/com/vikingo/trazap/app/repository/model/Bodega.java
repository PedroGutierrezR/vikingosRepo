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
@SequenceGenerator(name = "bodega_id_seq", initialValue = 1, sequenceName = "bodega_id_seq", allocationSize = 1)
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bodega_id_seq")
	@Column(name = "id_bodega")
	private int idBodega;
	private String descripcion;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "bodega_id")
	private List<ProductosBodega> productosBodegas;
	
	@Override
	public String toString() {
		return "Bodega [idBodega=" + idBodega + ", descripcion=" + descripcion + "]";
	}
	
}
