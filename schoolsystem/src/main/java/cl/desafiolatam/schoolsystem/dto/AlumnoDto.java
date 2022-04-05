package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.schoolsystem.dao.model.Alumno;
import cl.desafiolatam.schoolsystem.dao.model.Curso;

public class AlumnoDto {
	private List<Alumno> alumnos;
	private String mensajeNuevoAlumno;
	private String mensaje;
	
	public AlumnoDto() {
		super();
		// TODO Auto-generated constructor stub
		this.alumnos = new ArrayList<Alumno>();
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void setAlumnoFromJson(String json) {
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		String dataSplit[] = json.split("&");

		alumno.setNombre(dataSplit[0].split("=")[1]);
		alumno.setApellido(dataSplit[1].split("=")[1]);
		alumno.setFechaNac(dataSplit[2].split("=")[1]);
		curso.setIdCurso((Integer.parseInt(dataSplit[3].split("=")[1])));
		alumno.setCurso(curso);
		
		this.alumnos.add(alumno);
	}
	
	public void setEditarAlumnoFromJson(String json) {
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		String dataSplit[] = json.split("&");
		alumno.setIdAlumno(Integer.parseInt(dataSplit[0].split("=")[1]));
		alumno.setNombre(dataSplit[1].split("=")[1]);
		alumno.setApellido(dataSplit[2].split("=")[1]);
		alumno.setFechaNac(dataSplit[3].split("=")[1]);
		curso.setIdCurso(Integer.parseInt(dataSplit[4].split("=")[1]));
		alumno.setCurso(curso);
		
		this.alumnos.add(alumno);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub}
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public String getMensajeNuevoAlumno() {
		return mensajeNuevoAlumno;
	}

	public void setMensajeNuevoAlumno(String mensajeNuevoAlumno) {
		this.mensajeNuevoAlumno = mensajeNuevoAlumno;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
