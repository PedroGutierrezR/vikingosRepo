package cl.desafiolatam.schoolsystem.dao.model;

public class Asignatura {

	private int idAsignatura;
	private String descripcion;
	private TipoAsignatura tipoAsignatura;
	
	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String decripcion) {
		this.descripcion = decripcion;
	}

	public TipoAsignatura getTipoAsignatura() {
		return tipoAsignatura;
	}

	public void setTipoAsignatura(TipoAsignatura tipoAsignatura) {
		this.tipoAsignatura = tipoAsignatura;
	}

}
