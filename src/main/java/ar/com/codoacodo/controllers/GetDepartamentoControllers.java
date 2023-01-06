package ar.com.codoacodo.controllers;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.domain.Departamento;

public class GetDepartamentoControllers {

	public static void main(String[] args) {
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		
		int id = 14;
		Departamento d;
		
		try {
			d = dao.getById(id);
		}
		catch(Exception e) {
			d = null;
		}
	
		if(d != null) {
			System.out.print(d);
		}
		else {
			System.err.print("No existe el registro "+id);
		}
	}
}
