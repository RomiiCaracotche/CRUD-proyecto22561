package ar.com.codoacodo.DAO.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.DAO.EmpleadoDAO;
import ar.com.codoacodo.db.AdministradorDeConexion;
import ar.com.codoacodo.domain.Empleado;


public class EmpleadoDAOImpl implements EmpleadoDAO {
	
	@Override
	public Empleado getByDni(int dni)  throws Exception{

		Connection conection = AdministradorDeConexion.getConection();
		String sql = "select * from empleados where dni = " + dni;
		Statement statement  = conection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
	     // primero verifico si hay datos 
		
		if (resultset.next()){
			int dniBd = resultset.getInt("dni");
			String nombreBd = resultset.getString("nombre");
			String apellidoBd = resultset.getString("apellido");
			int departamentoBd = resultset.getInt("id");
			return new Empleado(dniBd, nombreBd, apellidoBd, departamentoBd);
			
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
			int dniBd = resultset.getInt("dni");
			String nombreBd = resultset.getString("nombre");
			String apellidoBd = resultset.getString("apellido");
			int departamentoBd = resultset.getInt("departamento");

			Empleado e = new Empleado(dniBd,nombreBd,apellidoBd, departamentoBd);
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
		 String sql = "update empleados set nombre = ?, apellido = ?, departamento = ? where dni= ?"  ;
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
		 String sql = "insert into empleados (dni, nombre, apellido, departamento) values (?,?,?,?)" ;
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
			empleados.add(this.crearEmpleado(resultSet));
		}
		
		conection.close();
		return empleados;
	}
	
	
	private Empleado crearEmpleado(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo id
		int dniDb = resultSet.getInt("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		int departamentoDb = resultSet.getInt("idDpto");
	
		return new Empleado(dniDb, nombre, apellido, departamentoDb);
	}


}
