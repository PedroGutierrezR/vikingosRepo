package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cl.desafiolatam.schoolsystem.facade.CursoFacade;
import cl.desafiolatam.schoolsystem.facade.impl.CursoFacadeImpl;

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
		System.out.println(this.cursoFacade.getCursos().toString());
		
		req.setAttribute("cursoDtoJson", "");
		req.getServletContext().getRequestDispatcher("/mantenedoracursos.jsp").forward(req, resp);
		
	}



	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Hola put de curso");
		
	}
	
	
	
}
