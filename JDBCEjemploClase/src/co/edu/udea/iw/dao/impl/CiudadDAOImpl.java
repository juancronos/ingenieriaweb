package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Juan
 * @version 1.0
 * Esta clase hereda de la clase datasource su metodo para conectarse a bases de datos
 * Esta clase implementa los metodos de la interfaz CiudadDAO
 */
public class CiudadDAOImpl extends DataSource implements CiudadDAO {
	//este es el constructor
	public CiudadDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Este metodo conecta con la base de datos y devuelve una lista de objetos tipo ciudades que podremos iterar
	 */
	@Override
	public List<Ciudad> get() throws MyException {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();//las ciudades se guardaran en este arreglo
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {//conectaremos con la base de datos y realizaremos una consulta para obtener las ciudades
			con = getConnection();
			ps = con.prepareStatement("SELECT * FROM Ciudades ORDER BY Nombre");//cosulta a la base de datos
			rs = ps.executeQuery();
			
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				
				ciudad.setCodigo(rs.getLong("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				
				ciudades.add(ciudad);
			}
			
		} catch (SQLException e) {//en caso de error capturamos la execepcion y ppor medio de myexception especificamos que salio mal
			throw new MyException("Ocurrio un error obteniendo los datos ciudades");
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
	/**
	 * Retornamos el arreglo de ciudades
	 */
		return ciudades;
	
	}
}
