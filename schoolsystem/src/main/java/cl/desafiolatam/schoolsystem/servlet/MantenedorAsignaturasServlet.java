package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.desafiolatam.schoolsystem.facade.AsignaturaFacade;
import cl.desafiolatam.schoolsystem.facade.impl.AsignaturaFacadeImpl;

@WebServlet("/mantenedorasignatura.srv")
public class MantenedorAsignaturasServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AsignaturaFacade asignaturaFacade = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.asignaturaFacade = new AsignaturaFacadeImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hola get asignatura");
		req.setAttribute("asignaturaDtoJson", this.asignaturaFacade.getAsignaturas().toString());
		req.getServletContext().getRequestDispatcher("/mantenedoraasignaturas.jsp").forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
