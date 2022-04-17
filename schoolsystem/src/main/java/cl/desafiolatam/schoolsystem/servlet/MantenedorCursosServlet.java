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

		req.setAttribute("cursoDtoJson", this.cursoFacade.getCursos().toString());
		req.getServletContext().getRequestDispatcher("/mantenedoracursos.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = Utils.getJsonString(req.getInputStream());
		
		String dataSplit[] = json.split("&");
		
		int i = dataSplit.length -1;
		
		String accion = dataSplit[i].split("=")[1];
		
		CursoDto cursoDto = new CursoDto();
		
		int resultado = 0;
		
		System.out.println(accion);
		
		if(accion.equalsIgnoreCase("actualizarCurso")) {
			
			cursoDto.setCursoFromJson(json);
			resultado = this.cursoFacade.updateCurso(cursoDto);

			if(resultado == 1) {
				cursoDto = this.cursoFacade.getCursos();
				cursoDto.setMensaje("Actualizado Correctamente");
			}
		} else if(accion.equalsIgnoreCase("crearCurso")) {
			cursoDto.setCursoFromJsonAgregar(json);
			resultado = this.cursoFacade.addCurso(cursoDto);
			if(resultado == 1) {
				cursoDto = this.cursoFacade.getCursos();
				cursoDto.setMensaje("Agregado Correctamente");
			}
			
		}
	
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(cursoDto.toString()); 
        out.flush(); 
		
	}
		
}
