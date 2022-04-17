package cl.desafiolatam.schoolsystem.dao.model;

import java.util.List;

public class TipoAsignatura {
	private int idTipoAsignatura;
	private String descripcion;
	private List<Asignatura> asignaturas;

	public int getIdTipoAsignatura() {
		return idTipoAsignatura;
	}

	public void setIdTipoAsignatura(int idTipoAsignatura) {
		this.idTipoAsignatura = idTipoAsignatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}
