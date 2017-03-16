package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Juan
 * @version 1.0
 * La clase data source es la encargada de conectarse con la base de datos
 */
public class DataSource{
	/**
	 * Metodo que devuelve la conexion a la base de datos
	 * @return retorna un objeto de tipo connection
	 * @throws MyException excepcion personalizada creada para especificar el error ocurrido
	 * 
	 */
	
	public Connection getConnection() throws MyException{
		String url = "jdbc:mysql://localhost:3306/clase";//esta es la direccion de la base de datos
		String usuario = "Juantorres"; //usuario de la BD
		String pws = "UdeA2017";	//contraseña para acceder a la BD
		Connection con = null;		//objeto tipo connection que sera devuelto por este metodo
		
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			con = DriverManager.getConnection(url, usuario, pws);	
			
		}catch(ClassNotFoundException e){
			throw new MyException("El Drive a la Base de DAtos no ha sido encontrado", e);
		}catch (SQLException e) {
			throw new MyException("Ha ocurrido un error conectando a la Base de Datos", e);
		}
		
		return con;
	}
}
