package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import cl.desafiolatam.schoolsystem.dao.model.Curso;

public class CursoDto {

	private List<Curso> cursos;
	private String mensaje;
	
	public CursoDto() {
		super();
		this.cursos = new ArrayList<Curso>();
	}
	
	public void setCursoFromJson(String json) {
	
		Curso curso = new Curso();
		String dataSplit[] = json.split("&");
		curso.setIdCurso(Integer.parseInt(dataSplit[0].split("=")[1]));
		curso.setDescripcion(dataSplit[1].split("=")[1] + " " + dataSplit[2].split("=")[1] + " " + dataSplit[3].split("=")[1]);
		this.cursos.add(curso);
	}

	public void setCursoFromJsonAgregar(String json) {
		
		Curso curso = new Curso();
		String dataSplit[] = json.split("&");
		curso.setDescripcion(dataSplit[0].split("=")[1] + " " + dataSplit[1].split("=")[1] + " " + dataSplit[2].split("=")[1]);
		this.cursos.add(curso);
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
