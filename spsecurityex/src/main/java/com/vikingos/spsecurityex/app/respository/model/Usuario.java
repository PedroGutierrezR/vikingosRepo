package com.vikingos.spsecurityex.app.respository.model;

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
@SequenceGenerator(name = "usuario_id_seq", initialValue = 1, sequenceName = "usuario_id_seq", allocationSize = 1)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
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
