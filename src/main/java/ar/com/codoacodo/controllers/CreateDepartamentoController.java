package ar.com.codoacodo.controllers;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.domain.Departamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateDepartamentoController")
public class CreateDepartamentoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//parametros del request
		String id = req.getParameter("id");
		String nombre = req.getParameter("nombre");
		String presupuesto = req.getParameter("presupuesto");
		
		//validaciones
		List<String> errores = new ArrayList<>();
		if(nombre == null || "".equals(nombre)) {
			errores.add("Nombre vacío");
		}
		if(id == null || "".equals(id)) {
			errores.add("Id vacío");
		}
		if(presupuesto == null || "".equals(presupuesto)) {
			errores.add("Presupuesto vacío");
		}
		
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores); 
			getServletContext().getRequestDispatcher("/nuevo.jsp").forward(req, resp);
			return;
		}

		DepartamentoDAO dao = new DepartamentoDAOImpl();
		Departamento d = new Departamento(Integer.parseInt(id), nombre, Double.parseDouble(presupuesto));
		
		// si no usamos try catch podemos arriba poner throws Exception
		try {
			 dao.create(d);
			 req.setAttribute("success", List.of("Alta exitosa"));
		}
		catch (Exception e) {
			e.printStackTrace();
			
		 }

		getServletContext().getRequestDispatcher("/FindAllDepartamentoController").forward(req, resp);
			
	}

}
