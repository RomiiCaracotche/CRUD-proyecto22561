package ar.com.codoacodo.controllers;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.domain.Departamento;

public class CreateDepartamentoController {

	public static void main(String[] args) throws Exception {
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		
		Departamento d;
		int idDb = 80;
		String nombreDb = "creado desde java";
		Double presupuestoDb = 220000.00;
		d = new Departamento(idDb, nombreDb, presupuestoDb);
		dao.create(d);
		System.out.print(d);
	}

}
