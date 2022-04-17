package cl.desafiolatam.schoolsystem.facade;

<<<<<<< HEAD
public interface ProfesorFacade {
=======
//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;

public interface ProfesorFacade {
	
	public ProfesorDto getProfesores();
	public ProfesorDto addProfesor(ProfesorDto profesorDto);
	public int update(ProfesorDto profesorDto);
	public int deleteById(int id_profesor);
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8

}
