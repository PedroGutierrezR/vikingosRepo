package cl.desafiolatam.schoolsystem.service.impl;

import cl.desafiolatam.schoolsystem.dao.AsignaturaDao;
import cl.desafiolatam.schoolsystem.dao.impl.AsignaturaDaoImpl;
import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
import cl.desafiolatam.schoolsystem.dto.AsignaturaDto;
import cl.desafiolatam.schoolsystem.service.AsignaturaService;

public class AsignaturaServiceImpl implements AsignaturaService {

	private AsignaturaDao asignaturaDao = null;
	
	public AsignaturaServiceImpl() {
		this.asignaturaDao = new AsignaturaDaoImpl(); 
	}
	
	@Override
	public AsignaturaDto getAsignaturas() {
		AsignaturaDto asignaturaDto = new AsignaturaDto();
		asignaturaDto.setAsignaturas(asignaturaDao.getAll()); 
		return asignaturaDto;
	}

	@Override
	public int updateAsignatura(AsignaturaDto asignaturaDto) {
		return 0;
	}

	@Override
	public int addAsignatura(AsignaturaDto asignaturaDto) {
		Asignatura asignatura = new Asignatura();
		asignatura = asignaturaDto.getAsignaturas().get(0);
		return asignaturaDao.add(asignatura);
	}

}
