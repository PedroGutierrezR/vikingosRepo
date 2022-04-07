package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.schoolsystem.dao.model.Asignatura;

public class AsignaturaDto {

	private List<Asignatura> asignaturas;
	private String mensaje;
	
	public AsignaturaDto() {
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
