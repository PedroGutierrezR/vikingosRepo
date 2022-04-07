package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.schoolsystem.dao.model.TipoAsignatura;

public class TipoAsignaturaDto {

	private List<TipoAsignatura> tipoAsignaturas;
	private String mensaje;
	
	public TipoAsignaturaDto() {
		this.tipoAsignaturas = new ArrayList<TipoAsignatura>();
	}
	
	public List<TipoAsignatura> getTipoAsignaturas() {
		return tipoAsignaturas;
	}

	public void setTipoAsignaturas(List<TipoAsignatura> tipoAsignaturas) {
		this.tipoAsignaturas = tipoAsignaturas;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
