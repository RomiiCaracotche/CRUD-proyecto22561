package ar.com.codoacodo.DAO;
import java.util.List;

import ar.com.codoacodo.domain.Departamento;

public interface DepartamentoDAO {

	//devuelvo el dpto con el id pasado por parametro
	//select * from departamentos where id = id
	public Departamento getById(int id) throws Exception;
	
	//devuelve todos los departamentos de la tabla
	//select * from departamentos
	public List<Departamento> findAll() throws Exception;

	//delete from departamentos where id = id
	//borra el dpto con el id pasado por parametro
	public void delete(int id) throws Exception;
	
	//actualiza un departamento
	//update departamentos set nombre = nombre, presupuesto = presupuesto where id = dpto.id 
	public void update(Departamento dpto) throws Exception;

	//inserta un departamento en la tabla
	//insert to departamentos (Departamento dpto) throws Exception;
	public void create (Departamento dpto) throws Exception;

	
	//select * from departamentos where titulo like '%clave%' 
    public List<Departamento> search(String clave) throws Exception;
}
