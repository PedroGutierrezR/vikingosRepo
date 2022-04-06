package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;
import cl.desafiolatam.schoolsystem.facade.ProfesorFacade;
import cl.desafiolatam.schoolsystem.facade.impl.ProfesorFacadeImpl;
import cl.desafiolatam.schoolsystem.genericUtils.Utils;

@WebServlet("/mantenedorprofesor.srv")
public class MantenedorProfesoresServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProfesorFacade profesorFacade;
	
	@Override
	public void init() throws ServletException{
		super.init();
		this.profesorFacade = new ProfesorFacadeImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Hola get");
		
		req.setAttribute("profesorDtoJson", this.profesorFacade.getProfesores().toString());
		//req.setAttribute("cursoDto", this.cursoFacade.getCursos());
		req.getServletContext().getRequestDispatcher("/mantenedorprofesores.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String json = Utils.getJsonString(req.getInputStream());
		
		String dataSplit[] = json.split("&");
		
		int i = dataSplit.length -1;
		
		String accion = dataSplit[i].split("=")[1];
		ProfesorDto profesorDto = new ProfesorDto();
		if(accion.equalsIgnoreCase("eliminarProfesor")) {
			int resultado = this.profesorFacade.deleteById(Integer.parseInt(dataSplit[0].split("=")[1]));
			if(resultado == 1) {
				profesorDto = this.profesorFacade.getProfesores();
				profesorDto.setMensaje("Eliminado Correctamente");
			} 
		} else if(accion.equalsIgnoreCase("crearProfesor")) {
			profesorDto.setProfesorFromJson(json);	
			profesorDto = this.profesorFacade.addProfesor(profesorDto);
		} else if(accion.equalsIgnoreCase("actualizarProfesor")) {
			
			profesorDto.setEditarProfesorFromJson(json);
			this.profesorFacade.update(profesorDto);
			profesorDto = this.profesorFacade.getProfesores();
			profesorDto.setMensaje("Actualizado Correctamente");
		} 
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(profesorDto.toString()); 
        out.flush(); 
	
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doDelete(req, resp);
	}

	
	
}
