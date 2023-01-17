package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.DAO.EmpleadoDAO;
import ar.com.codoacodo.DAO.implement.EmpleadoDAOImpl;
import ar.com.codoacodo.domain.Empleado;

@WebServlet("/FindAllEmpleadoController")
public class FindAllEmpleadoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		EmpleadoDAO dao = new EmpleadoDAOImpl();
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			empleados = dao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("listadoEmpleados", empleados);
		getServletContext().getRequestDispatcher("/listarEmpleados.jsp").forward(req, resp);
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
