package ar.com.codoacodo.controllers;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.domain.Departamento;

public class UpdateDepartamentoController {

	public static void main(String[] args) throws Exception {
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		
		Departamento d;
		int idBd = 14;
		String nombreBd ="Sistema desde java";
		Double presupuestoBd = 95000.00;
		d = new Departamento(idBd, nombreBd, presupuestoBd);
		dao.update(d);
		System.out.print(d);

	}

}
