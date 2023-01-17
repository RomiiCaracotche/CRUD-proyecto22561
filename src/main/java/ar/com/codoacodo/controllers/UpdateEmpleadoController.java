package ar.com.codoacodo.controllers;

import java.io.IOException;
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

@WebServlet("/UpdateEmpleadoController")
public class UpdateEmpleadoController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int dni = Integer.parseInt(req.getParameter("dni"));
		String nombre= req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		int departamento = Integer.parseInt(req.getParameter("departamento"));

		EmpleadoDAO dao = new EmpleadoDAOImpl();
		Empleado emp = new Empleado(dni, nombre, apellido, departamento);
		
		try { 
			dao.update(emp);
			req.setAttribute("success", List.of("Empleado con dni:" + emp.getDni() + " actualizado correctamente"));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Error actualizando Empleados" + e.getMessage()));
		}
		

	     getServletContext().getRequestDispatcher("/FindAllEmpleadoController").forward(req, resp);
		
		
	}
	
	//cargar el departamento y enviarlo a la jsp que va a editar los datos
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int dni = Integer.parseInt(req.getParameter("dni"));
			EmpleadoDAO dao = new EmpleadoDAOImpl();	
			Empleado emp = null;

			try {
				emp = dao.getByDni(dni);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			req.setAttribute("empleado", emp);
		    getServletContext().getRequestDispatcher("/editarEmpleado.jsp").forward(req, resp);
		}

}
