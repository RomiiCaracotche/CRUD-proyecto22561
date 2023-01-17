package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.EmpleadoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.DAO.implement.EmpleadoDAOImpl;
import ar.com.codoacodo.domain.Departamento;
import ar.com.codoacodo.domain.Empleado;

@WebServlet("/CreateEmpleadoController")
public class CreateEmpleadoController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int dni = Integer.parseInt(req.getParameter("dni"));
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		int departamento = Integer.parseInt(req.getParameter("departamento"));
		//validaciones
//		List<String> errores = new ArrayList<>();
//		if(nombre == null || "".equals(nombre)) {
//			errores.add("Nombre vacío");
//		}
//		if(dni == 0 || "".equals(dni)) {
//			errores.add("Dni vacío");
//		}
//		if(apellido == null || "".equals(apellido)) {
//			errores.add("apellido vacío");
//		}
//		if(departamento == 0 || "".equals(departamento)) {
//			errores.add("departamento vacío");
//		}
		
//		if(!errores.isEmpty()) {
//			req.setAttribute("errors", errores); 
//			getServletContext().getRequestDispatcher("/nuevoEmpleado.jsp").forward(req, resp);
//			return;
//		}
		
		EmpleadoDAO dao = new EmpleadoDAOImpl();
		Empleado emp = new Empleado(dni, nombre, apellido, departamento);
		
		try {
			 dao.create(emp);
			 req.setAttribute("success", List.of("Alta exitosa"));
		}
		catch (Exception e) {
			e.printStackTrace();
			
		 }

		getServletContext().getRequestDispatcher("/FindAllEmpleadoController").forward(req, resp);
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		List<Departamento> listaDepartamentos = null;
		
		try {
			 listaDepartamentos = dao.findAll();
			 req.setAttribute("listaDepartamentos", listaDepartamentos);

		}
		catch (Exception e) {
			e.printStackTrace();
			
		 }

		getServletContext().getRequestDispatcher("/nuevoEmpleado.jsp").forward(req, resp);
	}
	
	
}
