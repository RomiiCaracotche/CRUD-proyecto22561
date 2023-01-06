package ar.com.codoacodo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexion {

	public static Connection getConection() {
		String hosts = "localhost";
		String port = "3306";
		String password = "";
		String username = "root";
		String nombredb = "desafio";
		
		//driver de conexion a la bbdd
		String driveClassName = "com.mysql.cj.jdbc.Driver";
		Connection connection;
		try {
			//com.mysql.cj.jdbc construye la clase a partir de un objeto compilado
			Class.forName(driveClassName);
			//url de conexion
			String url = "jdbc:mysql://"+hosts+":"+port+"/"+nombredb+"?serverTimeZone=UTC&useSSL=false";
			connection = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e){
			connection = null;
		}
		return connection;
	}
	
	public static void main(String[] args) {
		Connection con = AdministradorDeConexion.getConection();
		if(con != null) {
			System.out.print("Conexion exitosa");
		}
		else {
			System.out.print("Conexion fallida");
		}
	}
}
