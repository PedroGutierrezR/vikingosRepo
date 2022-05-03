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
@SequenceGenerator(name="usuarios_id_usuario_seq", initialValue = 1, allocationSize = 1, sequenceName = "usuarios_id_usuario_seq")
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_usuario_seq")
	@Column(name = "id_usuario")
	private int idUsuario;
	private String nombre;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", password=" + password
				+ ", rol=" + rol.getDescripcion() + "]";
	}
	
}
