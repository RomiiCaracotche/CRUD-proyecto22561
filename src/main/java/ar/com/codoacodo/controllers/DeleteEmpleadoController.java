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

@WebServlet("/DeleteEmpleadoController")
public class DeleteEmpleadoController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int dni = Integer.parseInt(req.getParameter("dni"));
		EmpleadoDAO dao = new EmpleadoDAOImpl();
		
		try {
			dao.delete(dni);
			req.setAttribute("success", List.of("Se he eliminado el producto con id:" + dni));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erorrs", List.of("NO se he eliminado el producto :" + e.getMessage()));
		}
		
		getServletContext().getRequestDispatcher("/FindAllEmpleadoController").forward(req, resp);
		
	}


}
