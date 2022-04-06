package cl.desafiolatam.schoolsystem.facade;

//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;

public interface ProfesorFacade {
	
	public ProfesorDto getProfesores();
	public ProfesorDto addProfesor(ProfesorDto profesorDto);
	public int update(ProfesorDto profesorDto);
	public int deleteById(int id_profesor);

}
