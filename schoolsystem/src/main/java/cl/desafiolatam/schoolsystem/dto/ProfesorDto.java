package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

//import cl.desafiolatam.schoolsystem.dao.model.Alumno;
//import cl.desafiolatam.schoolsystem.dao.model.Curso;
import cl.desafiolatam.schoolsystem.dao.model.Profesor;

public class ProfesorDto {

	private List<Profesor> profesores;
	private String mensajeNuevoProfesor;
	private String mensaje;
	
	public ProfesorDto() {
		super();
		// TODO Auto-generated constructor stub
		this.profesores = new ArrayList<Profesor>();
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public void setProfesorFromJson(String json) {
		Profesor profesor = new Profesor();
		//Curso curso = new Curso();
		
		String dataSplit[] = json.split("&");

		profesor.setNombre(dataSplit[0].split("=")[1]);
		profesor.setApellido(dataSplit[1].split("=")[1]);
		//curso.setIdCurso((Integer.parseInt(dataSplit[3].split("=")[1])));
		//alumno.setCurso(curso);
		
		this.profesores.add(profesor);
	}
	
	public void setEditarProfesorFromJson(String json) {
		Profesor profesor = new Profesor();
		//Curso curso = new Curso();
		String dataSplit[] = json.split("&");
		profesor.setId_profesor(Integer.parseInt(dataSplit[0].split("=")[1]));
		profesor.setNombre(dataSplit[1].split("=")[1]);
		profesor.setApellido(dataSplit[2].split("=")[1]);
		//alumno.setFechaNac(dataSplit[3].split("=")[1]);
		//curso.setIdCurso(Integer.parseInt(dataSplit[4].split("=")[1]));
		//alumno.setCurso(curso);
		
		this.profesores.add(profesor);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub}
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public String getMensajeNuevoProfesor() {
		return mensajeNuevoProfesor;
	}

	public void setMensajeNuevoProfesor(String mensajeNuevoProfesor) {
		this.mensajeNuevoProfesor = mensajeNuevoProfesor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
