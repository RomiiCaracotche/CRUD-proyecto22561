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

@WebServlet("/SearchDepartamentoController")
public class SearchDepartamentoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		EmpleadoDAO dao_emp = new EmpleadoDAOImpl();
		List<Empleado> empleados = new ArrayList<Empleado>();
		Set id_empleados = new HashSet();
		//obtengo la clave enviado desde el formulario que esta en navbar.jsp 
		String clave = req.getParameter("claveBusqueda");
		
		//FALTAN VALIDACIONES!!!

		List<Departamento> departamentos;
		
		try {
			departamentos = dao.search(clave);
			empleados = dao_emp.findAll();
			for(Empleado e: empleados) {
				id_empleados.add(e.getDepartamento());
			}
			
		} catch (Exception e) {
			departamentos = List.of();//crea una lista vacia
			e.printStackTrace();
		}

		req.setAttribute("listadoDepartamentos", departamentos);
		req.setAttribute("dptoConEmpleados", id_empleados);
		
		getServletContext().getRequestDispatcher("/listarDepartamentos.jsp").forward(req, resp);
	}
}
