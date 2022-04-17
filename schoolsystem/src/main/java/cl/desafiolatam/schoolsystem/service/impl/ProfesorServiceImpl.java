package cl.desafiolatam.schoolsystem.service.impl;

//import cl.desafiolatam.schoolsystem.dao.AlumnoDao;
import cl.desafiolatam.schoolsystem.dao.ProfesorDao;
//import cl.desafiolatam.schoolsystem.dao.impl.AlumnoDaoImpl;
import cl.desafiolatam.schoolsystem.dao.impl.ProfesorDaoImpl;
//import cl.desafiolatam.schoolsystem.dao.model.Alumno;
import cl.desafiolatam.schoolsystem.dao.model.Profesor;
//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;
import cl.desafiolatam.schoolsystem.service.ProfesorService;

public class ProfesorServiceImpl implements ProfesorService{

	private ProfesorDao profesorDao = null;
	//private Object profesorDao;
		
	public ProfesorServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.profesorDao = new ProfesorDaoImpl();
	}

	@Override
	public ProfesorDto getProfesores() {
		// TODO Auto-generated method stub
		ProfesorDto profesorDto = new ProfesorDto();
		profesorDto.setProfesores(this.profesorDao.getAll());
		return profesorDto;
	}

	@Override
	public int addProfesores(ProfesorDto profesorDto) {
		Profesor profesor = new Profesor();
		profesor = profesorDto.getProfesores().get(0);
		return this.profesorDao.add(profesor);
	}

	@Override
	public int deleteById(int idProfesor) {
		return profesorDao.delete(idProfesor);
	}

	@Override
	public int update(ProfesorDto profesorDto) {
		Profesor profesor = new Profesor();
		
		profesor.setId_profesor(profesorDto.getProfesores().get(0).getId_profesor());
		profesor.setNombre(profesorDto.getProfesores().get(0).getNombre());
		profesor.setApellido(profesorDto.getProfesores().get(0).getApellido());
		//alumno.setFechaNac(alumnoDto.getAlumnos().get(0).getFechaNac());
		//alumno.setCurso(alumnoDto.getAlumnos().get(0).getCurso());
		
		return this.profesorDao.update(profesor);
	}
	
	
}
