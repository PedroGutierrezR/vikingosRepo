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
@SequenceGenerator(name = "tipo_producto_id_seq", initialValue = 1, sequenceName = "tipo_producto_id_seq", allocationSize = 1)
public class TipoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_producto_id_seq")
	@Column(name = "id_tipo_producto")
	private int idTipoProducto;
	private String descripcion;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_producto_id")
	private List<Producto> productos;
	
	@Override
	public String toString() {
		return "TipoProducto [idTipoProducto=" + idTipoProducto + ", descripcion=" + descripcion + ", productos="
				+ productos + "]";
	}

}