package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafiolatam.schoolsystem.dto.CursoDto;
import cl.desafiolatam.schoolsystem.facade.CursoFacade;
import cl.desafiolatam.schoolsystem.facade.impl.CursoFacadeImpl;
import cl.desafiolatam.schoolsystem.genericUtils.Utils;

@WebServlet("/mantenedorcurso.srv")
public class MantenedorCursosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CursoFacade cursoFacade = null;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.cursoFacade = new CursoFacadeImpl();
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("entre a get");
		
		//String cursoDto = this.cursoFacade.getCursos().toString();
		//System.out.println(cursoDto);

		req.setAttribute("cursoDtoJson", this.cursoFacade.getCursos().toString());
		req.getServletContext().getRequestDispatcher("/mantenedoracursos.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Hola put de curso");
		
		String json = Utils.getJsonString(req.getInputStream());
		
		String dataSplit[] = json.split("&");
		
		int i = dataSplit.length -1;
		
		String accion = dataSplit[i].split("=")[1];
		
		CursoDto cursoDto = new CursoDto();
		
		if(accion.equalsIgnoreCase("actualizarCurso")) {
			
			cursoDto.setCursoFromJson(json);
			int resultado = this.cursoFacade.update(cursoDto);
			System.out.println(resultado);
			if(resultado == 1) {
				cursoDto = this.cursoFacade.getCursos();
				System.out.println("Estoy dentro");
				cursoDto.setMensaje("Actualizado Correctamente");
			}

		} 
//		else if(accion.equalsIgnoreCase("crearAlumno")) {
//			alumnoDto.setAlumnoFromJson(json);	
//			alumnoDto = this.alumnoFacade.addAlumno(alumnoDto);
//		} else if(accion.equalsIgnoreCase("actualizarAlumno")) {
//			
//			alumnoDto.setEditarAlumnoFromJson(json);
//			this.alumnoFacade.update(alumnoDto);
//			alumnoDto = this.alumnoFacade.getAlumnos();
//			alumnoDto.setMensaje("Actualizado Correctamente");
//		} 
//		
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(cursoDto.toString()); 
        out.flush(); 
	
		
		
	}
	
	
	
}
