package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@WebServlet("/SearchEmpleadoController")
public class SearchEmpleadoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpleadoDAO dao = new EmpleadoDAOImpl();
		String clave = req.getParameter("claveBusqueda");
		
		//FALTAN VALIDACIONES!!!

		List<Empleado> empleados;
		
		try {
			empleados = dao.search(clave);
			
		} catch (Exception e) {
			empleados = List.of();//crea una lista vacia
			e.printStackTrace();
		}

		req.setAttribute("listaEmpleados", empleados);
		
		getServletContext().getRequestDispatcher("/listarEmpleados.jsp").forward(req, resp);
	}
}
