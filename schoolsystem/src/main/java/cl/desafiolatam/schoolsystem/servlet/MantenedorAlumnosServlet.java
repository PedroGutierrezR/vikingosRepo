package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.facade.AlumnoFacade;
import cl.desafiolatam.schoolsystem.facade.CursoFacade;
import cl.desafiolatam.schoolsystem.facade.impl.AlumnoFacadeImpl;
import cl.desafiolatam.schoolsystem.facade.impl.CursoFacadeImpl;
import cl.desafiolatam.schoolsystem.genericUtils.Utils;

@WebServlet("/mantenedoralumnos.srv")
public class MantenedorAlumnosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlumnoFacade alumnoFacade = null;
	private CursoFacade cursoFacade = null;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.alumnoFacade = new AlumnoFacadeImpl();
		this.cursoFacade = new CursoFacadeImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		//String pattern = "dd-MM-yyyy";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		req.setAttribute("alumnoDtoJson", this.alumnoFacade.getAlumnos().toString());
		req.setAttribute("cursoDto", this.cursoFacade.getCursos());
		req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String json = Utils.getJsonString(req.getInputStream());
		
		AlumnoDto alumnoDto = new AlumnoDto();
		alumnoDto.setAlumnoFromJson(json);
		
		alumnoDto = this.alumnoFacade.addAlumno(alumnoDto);
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(alumnoDto.toString()); 
        out.flush(); 
		
		//req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = Utils.getJsonString(req.getInputStream());
		System.out.println(json); 
		
		String[] listaStrings = json.split("=");
		int id = Integer.parseInt(listaStrings[1]);
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
		alumnoFacade.deleteById(id);
		req.setAttribute("alumnoDtoJson", this.alumnoFacade.getAlumnos().toString());
		
	}
	
	
	
	
	
}
