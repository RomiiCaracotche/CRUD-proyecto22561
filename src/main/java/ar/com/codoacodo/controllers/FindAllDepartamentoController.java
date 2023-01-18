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


@WebServlet("/FindAllDepartamentoController")
public class FindAllDepartamentoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		DepartamentoDAO dao_dpto = new DepartamentoDAOImpl();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		
		EmpleadoDAO dao_emp = new EmpleadoDAOImpl();
		List<Empleado> empleados = new ArrayList<Empleado>();
		Set id_empleados = new HashSet();
		
		try {
			departamentos = dao_dpto.findAll();
			empleados = dao_emp.findAll();
			for(Empleado e: empleados) {
				id_empleados.add(e.getDepartamento());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//guarda en el request los departamentos devueltos por el dao bajo el nombre listadoDepartamentos
		req.setAttribute("listadoDepartamentos", departamentos);
		req.setAttribute("dptoConEmpleados", id_empleados);
		//en el contexto manda al jsp el request y response
		getServletContext().getRequestDispatcher("/listarDepartamentos.jsp").forward(req, resp);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
