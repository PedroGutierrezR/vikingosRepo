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
@SequenceGenerator(name = "productos_bodega_id_seq", initialValue = 1, sequenceName = "productos_bodega_id_seq", allocationSize = 1)
public class ProductosBodega {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_bodega_id_seq")
	@Column(name = "id_producto_bodega")
	private int idProductoBodega;
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "bodega_id")
	private Bodega bodega;
	private int stock; 
	
	@Override
	public String toString() {
		return "ProductosBodega [idProductoBodega=" + idProductoBodega + ", producto=" + producto + ", bodega=" + bodega
				+ "]";
	}
	
}
