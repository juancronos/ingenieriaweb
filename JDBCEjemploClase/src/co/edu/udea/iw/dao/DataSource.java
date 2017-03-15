package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

import co.edu.udea.iw.exception.MyException;

public class DataSource{
	public Connection getConnection() throws MyException{
		String url = "jdbc:mysql://localhost:3306/clase";
		String usuario = "Juantorres";
		String pws = "UdeA2017";		
		Connection con = null;
		
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
