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
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.domain.Departamento;


@WebServlet("/FindAllDepartamentoController")
public class FindAllDepartamentoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		
		try {
			departamentos = dao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//guarda en el request los departamentos devueltos por el dao bajo el nombre listadoDepartamentos
		req.setAttribute("listadoDepartamentos", departamentos);
		//en el contexto manda al jsp el request y response
		getServletContext().getRequestDispatcher("/listarDepartamentos.jsp").forward(req, resp);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
