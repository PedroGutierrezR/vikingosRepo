package cl.desafiolatam.schoolsystem.servlet;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import cl.desafiolatam.schoolsystem.facade.ProfesorFacade;
import cl.desafiolatam.schoolsystem.facade.impl.ProfesorFacadeImpl;

@WebServlet("/mantenedorprofesor.srv")
=======
//import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.ProfesorDto;
import cl.desafiolatam.schoolsystem.facade.ProfesorFacade;
import cl.desafiolatam.schoolsystem.facade.impl.ProfesorFacadeImpl;
import cl.desafiolatam.schoolsystem.genericUtils.Utils;

@WebServlet("/mantenedorprofesores.srv")
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
public class MantenedorProfesoresServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private ProfesorFacade profesorFacade;
=======
	private ProfesorFacade profesorFacade = null;
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	
	@Override
	public void init() throws ServletException{
		super.init();
		this.profesorFacade = new ProfesorFacadeImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		System.out.println("Hola get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
=======
		//System.out.println("Hola get");
		
		req.setAttribute("profesorDtoJson", this.profesorFacade.getProfesores().toString());
		//req.setAttribute("cursoDto", this.cursoFacade.getCursos());
		req.getServletContext().getRequestDispatcher("/mantenedorprofesores.jsp").forward(req, resp);
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		super.doPut(req, resp);
=======
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
	
        //req.setAttribute("profesorDtoJson", this.profesorFacade.getProfesores().toString());
		//req.setAttribute("cursoDto", this.cursoFacade.getCursos());
		//req.getServletContext().getRequestDispatcher("/mantenedorprofesores.jsp").forward(req, resp);
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		super.doDelete(req, resp);
=======
		//super.doDelete(req, resp);
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	}

	
	
}
