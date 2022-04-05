package cl.desafiolatam.schoolsystem.facade.impl;

import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.facade.AlumnoFacade;
import cl.desafiolatam.schoolsystem.service.AlumnoService;
import cl.desafiolatam.schoolsystem.service.impl.AlumnoServiceImpl;

public class AlumnoFacadeImpl implements AlumnoFacade{
	private AlumnoService alumnoService = null;
	public AlumnoFacadeImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.alumnoService = new AlumnoServiceImpl();
	}

	@Override
	public AlumnoDto getAlumnos() {
		return this.alumnoService.getAlumnos();
	}

	@Override
	public AlumnoDto addAlumno(AlumnoDto alumnoDto) {
		int resultado = this.alumnoService.addAlumnos(alumnoDto);
		AlumnoDto alumnoDtoResultado = this.alumnoService.getAlumnos();
		if(resultado == 1) {
			alumnoDtoResultado.setMensajeNuevoAlumno("El alumno se ha guardado correctamente");
		}else if (resultado == 0){
			alumnoDtoResultado.setMensajeNuevoAlumno("El alumno NO se ha guardado correctamente");
		}else {
			alumnoDtoResultado.setMensajeNuevoAlumno("Error al guardar el alumno");
		}
		
		return alumnoDtoResultado;
	}

	@Override
	public int deleteById(int idAlumno) {	
		return alumnoService.deleteById(idAlumno);
	}

	@Override
	public int update(int idAlumno) {
		return alumnoService.update(idAlumno);
	}

}
