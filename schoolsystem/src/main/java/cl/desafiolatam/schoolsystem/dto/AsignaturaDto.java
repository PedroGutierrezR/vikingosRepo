package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
import cl.desafiolatam.schoolsystem.dao.model.TipoAsignatura;

public class AsignaturaDto {

	private List<Asignatura> asignaturas;
	private String mensaje;
	
	public AsignaturaDto() {
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public void setAsignaturaFromJsonAgregar(String json) {
		
		Asignatura asignatura = new Asignatura();
		TipoAsignatura tipoAsignatura = new TipoAsignatura();
		
		String dataSplit[] = json.split("&");	
		asignatura.setDescripcion(dataSplit[0].split("=")[1]);
		tipoAsignatura.setIdTipoAsignatura(Integer.parseInt(dataSplit[1].split("=")[1]));
		asignatura.setTipoAsignatura(tipoAsignatura);
		this.asignaturas.add(asignatura);
		
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
