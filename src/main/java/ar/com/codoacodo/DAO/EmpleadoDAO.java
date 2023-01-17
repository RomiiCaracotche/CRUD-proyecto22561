package ar.com.codoacodo.DAO;

import java.util.List;

import ar.com.codoacodo.domain.Departamento;
import ar.com.codoacodo.domain.Empleado;

public interface EmpleadoDAO {
	
		//devuelvo el empleado con el dni pasado por parametro
		//select * from empleados where dni = dni
		public Empleado getByDni(int dni) throws Exception;
		
		//devuelve todos los empleados de la tabla
		//select * from empleados
		public List<Empleado> findAll() throws Exception;

		//delete from empleados where dni = dni
		//borra el empleado con el dni pasado por parametro
		public void delete(int dni) throws Exception;
		
		//actualiza un empleado
		//update empleados set nombre = nombre, apellido = apellido where dni = emp.dni 
		public void update(Empleado emp) throws Exception;

		//inserta un empleado en la tabla
		//insert to empleados (Empleado emp) throws Exception;
		public void create (Empleado emp) throws Exception;

		
		//select * from empleados where apellido like '%clave%' 
	    public List<Empleado> search(String clave) throws Exception;
}
