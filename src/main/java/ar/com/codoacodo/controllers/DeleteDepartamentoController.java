package ar.com.codoacodo.controllers;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;

public class DeleteDepartamentoController {

	public static void main(String[] args) throws Exception {
		int id = 14;
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		dao.delete(id);
		System.out.println("Se elimino corretamente");
	}

}
