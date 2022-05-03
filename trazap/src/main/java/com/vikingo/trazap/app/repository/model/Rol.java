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
@SequenceGenerator(name = "rol_id_rol_seq", initialValue = 1, allocationSize = 1, sequenceName = "rol_id_rol_seq")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_id_rol_seq")
	@Column(name = "id_rol")
	private int idRol;
	private String descripcion;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "rol_id")
	private List<Usuario> usuarios;
	
}
