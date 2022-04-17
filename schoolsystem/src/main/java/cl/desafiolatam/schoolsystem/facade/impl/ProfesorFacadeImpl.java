package cl.desafiolatam.schoolsystem.facade.impl;

<<<<<<< HEAD
import cl.desafiolatam.schoolsystem.facade.ProfesorFacade;

public class ProfesorFacadeImpl implements ProfesorFacade{

=======
//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;
import cl.desafiolatam.schoolsystem.facade.ProfesorFacade;
//import cl.desafiolatam.schoolsystem.service.AlumnoService;
import cl.desafiolatam.schoolsystem.service.ProfesorService;
//import cl.desafiolatam.schoolsystem.service.impl.AlumnoServiceImpl;
import cl.desafiolatam.schoolsystem.service.impl.ProfesorServiceImpl;

public class ProfesorFacadeImpl implements ProfesorFacade{

	private ProfesorService profesorService = null;
	public ProfesorFacadeImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.profesorService = new ProfesorServiceImpl();
	}

	@Override
	public ProfesorDto getProfesores() {
		return this.profesorService.getProfesores();
	}

	@Override
	public ProfesorDto addProfesor(ProfesorDto profesorDto) {
		int resultado = this.profesorService.addProfesores(profesorDto);
		ProfesorDto profesorDtoResultado = this.profesorService.getProfesores();
		if(resultado == 1) {
			profesorDtoResultado.setMensajeNuevoProfesor("El profesor se ha guardado correctamente");
		}else if (resultado == 0){
			profesorDtoResultado.setMensajeNuevoProfesor("El profesor NO se ha guardado correctamente");
		}else {
			profesorDtoResultado.setMensajeNuevoProfesor("Error al guardar el profesor");
		}
		
		return profesorDtoResultado;
	}

	@Override
	public int deleteById(int id_profesor) {	
		return profesorService.deleteById(id_profesor);
	}

	@Override
	public int update(ProfesorDto profesorDto) {
		return profesorService.update(profesorDto);
	}

>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
}
