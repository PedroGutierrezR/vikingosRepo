package cl.desafiolatam.schoolsystem.service.impl;

import cl.desafiolatam.schoolsystem.dao.AlumnoDao;
import cl.desafiolatam.schoolsystem.dao.impl.AlumnoDaoImpl;
import cl.desafiolatam.schoolsystem.dao.model.Alumno;
import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.service.AlumnoService;

public class AlumnoServiceImpl implements AlumnoService{
	private AlumnoDao alumnoDao = null;
	
	
	
	public AlumnoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.alumnoDao = new AlumnoDaoImpl();
	}



	@Override
	public AlumnoDto getAlumnos() {
		// TODO Auto-generated method stub
		AlumnoDto alumnoDto = new AlumnoDto();
		alumnoDto.setAlumnos(this.alumnoDao.getAll());
		return alumnoDto;
	}



	@Override
	public int addAlumnos(AlumnoDto alumnoDto) {
		// TODO Auto-generated method stub
		Alumno alumno = new Alumno();
		alumno = alumnoDto.getAlumnos().get(0);
		return this.alumnoDao.add(alumno);
	}



	@Override
	public int deleteById(int idAlumno) {
		return alumnoDao.deleteById(idAlumno);
	}

}
