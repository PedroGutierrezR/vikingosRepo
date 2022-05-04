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
@SequenceGenerator(name = "producto_id_seq", initialValue = 1, sequenceName = "producto_id_seq", allocationSize = 1)
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_seq")
	@Column(name = "id_producto")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id")
	private int idProducto;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "categoria_producto_id")
	private CategoriaProducto categoriaProducto;
	@ManyToOne
	@JoinColumn(name = "tipo_producto_id")
	private TipoProducto tipoProducto;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id")
	private List<ProductosBodega> productosBodegas;
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", categoriaProducto="
				+ categoriaProducto.getDescripcion() + ", tipoProducto=" + tipoProducto.getDescripcion() + ", productosBodegas=" + productosBodegas + "]";
	}
	
}
