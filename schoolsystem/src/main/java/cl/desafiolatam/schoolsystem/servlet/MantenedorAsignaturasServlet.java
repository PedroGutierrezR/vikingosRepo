package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.desafiolatam.schoolsystem.dto.AsignaturaDto;
import cl.desafiolatam.schoolsystem.facade.AsignaturaFacade;
import cl.desafiolatam.schoolsystem.facade.TipoAsignaturaFacade;
import cl.desafiolatam.schoolsystem.facade.impl.AsignaturaFacadeImpl;
import cl.desafiolatam.schoolsystem.facade.impl.TipoAsignaturaFacadeImpl;
import cl.desafiolatam.schoolsystem.genericUtils.Utils;

@WebServlet("/mantenedorasignatura.srv")
public class MantenedorAsignaturasServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AsignaturaFacade asignaturaFacade = null;
	private TipoAsignaturaFacade tipoAsignaturaFacade = null;

	@Override
	public void init() throws ServletException {
		super.init();
		this.asignaturaFacade = new AsignaturaFacadeImpl();
		this.tipoAsignaturaFacade = new TipoAsignaturaFacadeImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("asignaturaDtoJson", this.asignaturaFacade.getAsignaturas().toString());
		System.out.println(this.tipoAsignaturaFacade.getAll().toString());
		req.setAttribute("tipoAsignaturaDto", this.tipoAsignaturaFacade.getAll());
		req.getServletContext().getRequestDispatcher("/mantenedoraasignaturas.jsp").forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Hola put de asignatura");

		String json = Utils.getJsonString(req.getInputStream());

		String dataSplit[] = json.split("&");

		int i = dataSplit.length - 1;

		String accion = dataSplit[i].split("=")[1];
		System.out.println(accion);
		
		AsignaturaDto asignaturaDto = new AsignaturaDto();

		int resultado = 0;
		System.out.println(json);
		if(accion.equalsIgnoreCase("crearAsignatura")) {
			asignaturaDto.setAsignaturaFromJsonAgregar(json);
			resultado = this.asignaturaFacade.addAsignatura(asignaturaDto);
			if(resultado == 1) {
				asignaturaDto = this.asignaturaFacade.getAsignaturas();
				asignaturaDto.setMensaje("Agregado Correctamente");
			}
			
		}
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(asignaturaDto.toString()); 
        out.flush(); 
		
	}

}
