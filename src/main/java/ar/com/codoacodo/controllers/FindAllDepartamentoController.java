package ar.com.codoacodo.controllers;

import java.util.List;

import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.DAO.implement.DepartamentoDAOImpl;
import ar.com.codoacodo.domain.Departamento;

public class FindAllDepartamentoController {

	public static void main(String[] args) throws Exception {
		DepartamentoDAO dao = new DepartamentoDAOImpl();
		List<Departamento> departamentos;
		
		try {
			departamentos = dao.findAll();
		}
		catch(Exception e) {
			departamentos = null;
		}
		if(departamentos != null) {
			for(Departamento aux: departamentos) {
				System.out.println(aux);
				System.out.println("----------------------------");
			}
		}
		else {
			System.err.println("No hay registros en la tabla departamentos");
		}

	}

}
