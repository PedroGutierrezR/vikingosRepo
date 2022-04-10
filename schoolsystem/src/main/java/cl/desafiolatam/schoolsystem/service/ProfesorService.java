package cl.desafiolatam.schoolsystem.service;

//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;

public interface ProfesorService {

	public ProfesorDto getProfesores();
	public int addProfesores(ProfesorDto profesorDto);
	public int deleteById(int idAlumno);
	public int update(ProfesorDto id_profesor);
	
}
