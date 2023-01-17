package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;

@WebServlet("/DeleteDepartamentoController")
public class DeleteDepartamentoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("idDepto"));
		//interface = new class que implementa la interface
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		
		//eliminar
		try {
			dao.delete(id);
			System.out.println("Se he eliminado el producto con id:" + id);
			//mensaje de exito
			req.setAttribute("success", List.of("Se he eliminado el producto con id:" + id));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se puede eliminar el departamento seleccionado ya que tiene empleados a cargo");
			//mensaje de error
			req.setAttribute("erorrs", List.of("NO se he eliminado el producto :" + e.getMessage()));
		}//ctrl+t
		
		//ahora redirect!!!!
		getServletContext().getRequestDispatcher("/FindAllDepartamentoController").forward(req, resp);
		
		
	}

}