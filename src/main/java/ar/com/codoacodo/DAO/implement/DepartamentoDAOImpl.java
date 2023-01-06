package ar.com.codoacodo.DAO.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ar.com.codoacodo.DAO.DepartamentoDAO;
import ar.com.codoacodo.db.AdministradorDeConexion;
import ar.com.codoacodo.domain.Departamento;

public class DepartamentoDAOImpl implements DepartamentoDAO{
	
	//devuelvo el dpto con el id pasado por parametro
	@Override
	public Departamento getById(int id) throws Exception{
		//conecto la bbdd
		Connection connection = AdministradorDeConexion.getConection();
		//armo el statement
		String sql = "select * from departamentos where id=" +id;
		Statement statement = connection.createStatement();
		//obtengo el resulSet que devuelve el registro de la tabla
		ResultSet resultset = statement.executeQuery(sql);
		if(resultset.next()) {
			//obtengo los datos del registro
			int idDb = resultset.getInt("id");
			String nombreDb = resultset.getString("nombre");
			Double presupuestoDb = resultset.getDouble("presupuesto");
			return new Departamento(idDb, nombreDb, presupuestoDb);
		}
		
		//no encontro el registro
		return null;
	}
	
	//devuelve todos los departamentos de la tabla
	//select * from departamentos
	@Override
	public List<Departamento> findAll() throws Exception{
		//conecto la bbdd
		Connection connection = AdministradorDeConexion.getConection();
		//armo el statement
		String sql = "select * from departamentos";
		Statement statement = connection.createStatement();
		//obtengo el resulSet que devuelve el registro de la tabla
		ResultSet resultset = statement.executeQuery(sql);
		
		List<Departamento> departamentos = new ArrayList<Departamento>();
		while(resultset.next()) {
			//obtengo los datos del registro
			int idDb = resultset.getInt("id");
			String nombreDb = resultset.getString("nombre");
			Double presupuestoDb = resultset.getDouble("presupuesto");
			
			Departamento d = new Departamento(idDb, nombreDb, presupuestoDb);
			departamentos.add(d);
		}
		
		return departamentos;
	}

	//delete from departamentos where id = id
	//borra el dpto con el id pasado por parametro
	@Override
	public void delete(int id) throws Exception{
		Connection connection = AdministradorDeConexion.getConection();
		String sql = "delete from departamentos where id = "+id;
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
	}
	
	//actualiza un departamento
	//update departamentos set nombre = nombre, presupuesto = presupuesto where id = dpto.id 
	@Override
	public void update(Departamento dpto) throws Exception{
		Connection connection = AdministradorDeConexion.getConection();
		String sql = "update departamentos set nombre = ?, presupuesto = ? where id = ?";
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setInt(1, dpto.getId());
		statement.setString(2, dpto.getNombre());
		statement.setDouble(3, dpto.getPresupuesto());
		statement.execute();

	}

	//inserta un departamento en la tabla
	//insert to departamentos (Departamento dpto) throws Exception;
	@Override
	public void create (Departamento dpto) throws Exception{
		Connection connection = AdministradorDeConexion.getConection();
		String sql = "insert into departamentos (id,nombre, presupuesto) values (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setInt(1, dpto.getId());
		statement.setString(2, dpto.getNombre());
		statement.setDouble(3, dpto.getPresupuesto());
		statement.execute();
		
		ResultSet res = statement.getGeneratedKeys();
		if(res.next()) {
			System.out.print("Se creo el dpto correctamente");
		}
	}

}
