package ar.com.codoacodo.DAO.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.DAO.EmpleadoDAO;
import ar.com.codoacodo.db.AdministradorDeConexion;
import ar.com.codoacodo.domain.Departamento;
import ar.com.codoacodo.domain.Empleado;


public class EmpleadoDAOImpl implements EmpleadoDAO {
	
	@Override
	public Empleado getByDni(int dni)  throws Exception{

		Connection conection = AdministradorDeConexion.getConection();
		String sql = "select * from empleados where dni=" +dni;
		Statement statement  = conection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
	     // primero verifico si hay datos 
		
		if (resultset.next()){
			int dni_ = resultset.getInt("dni");
			String nombre = resultset.getString("nombre");
			String apellido = resultset.getString("apellido");
			int departamento = resultset.getInt("departamento");
			return new Empleado(dni_, nombre, apellido, departamento);
			
		}
		conection.close();
		return null; // si no hay resultset entonces no devuelve nada
	}

	@Override
	public List<Empleado> findAll() throws Exception {
		Connection conection = AdministradorDeConexion.getConection();
	    String sql = "select * from empleados";		   
		Statement statement  = conection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
				
	     // primero verifico si hay datos 
		List<Empleado> empleados = new ArrayList<Empleado>();	
			
		while (resultset.next()){
			int dni = resultset.getInt("dni");
			String nombre = resultset.getString("nombre");
			String apellido = resultset.getString("apellido");
			int departamento = resultset.getInt("departamento");

			Empleado e = new Empleado(dni, nombre, apellido, departamento);
			empleados.add(e);		
		}
		conection.close();	
	   return empleados; //
	}

	@Override
	public void delete(int dni) throws Exception {
		Connection conection = AdministradorDeConexion.getConection();
	     String sql = "DELETE FROM empleados WHERE dni=" + dni;
	 	 Statement statement  = conection.createStatement();
		  statement.executeUpdate(sql);
		  conection.close(); 
	}

	@Override
	public void update(Empleado emp) throws Exception {
		Connection conection = AdministradorDeConexion.getConection();
		 String sql = "UPDATE empleados SET nombre=?, apellido=?, departamento=? WHERE dni=?";
		 
		 PreparedStatement statement  = conection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setString(1,emp.getNombre());
	     statement.setString(2,emp.getApellido());
		 statement.setInt(3,emp.getDepartamento());
		 statement.setInt(4,emp.getDni());
		 statement.execute();
		 conection.close();
	}

	@Override
	public void create(Empleado emp) throws Exception {
		Connection conection = AdministradorDeConexion.getConection();
		 String sql = "INSERT INTO empleados (dni, nombre, apellido, departamento) VALUES (?,?,?,?)";
		 PreparedStatement statement  = conection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setInt(1,emp.getDni());
	     statement.setString(2,emp.getNombre());
		 statement.setString(3,emp.getApellido());
		 statement.setInt(4,emp.getDepartamento());
		 statement.execute();
		 
		 ResultSet res = statement.getGeneratedKeys(); // RETORNA LA KEY QUE SE GENERO
		 if (res.next()) {
			 System.out.println("Se creo el empleado correctamente");
		 }
		 conection.close();
	}
	
	@Override
	public List<Empleado> search(String clave) throws Exception {
		Connection conection = AdministradorDeConexion.getConection();
		String sql = "SELECT * FROM empleados WHERE apellido LIKE ?";
		PreparedStatement statement = conection.prepareStatement(sql);
		statement.setString(1, "%" + clave + "%");
		ResultSet resultSet = statement.executeQuery();

		List<Empleado> empleados = new ArrayList<Empleado>();
		
		while (resultSet.next()) {
			int dni = resultSet.getInt("dni");
			String nombre = resultSet.getString("nombre");
			String apellido = resultSet.getString("apellido");
			int departamento = resultSet.getInt("departamento");
			
			Empleado emp = new Empleado(dni, nombre, apellido, departamento);
			empleados.add(emp);
		}
		
		conection.close();
		return empleados;
	}
	

}
