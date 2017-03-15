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

public class CiudadDAOImpl extends DataSource implements CiudadDAO {

	public CiudadDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Ciudad> get() throws MyException {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("SELECT * FROM Ciudades ORDER BY Nombre");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				
				ciudad.setCodigo(rs.getLong("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				
				ciudades.add(ciudad);
			}
			
		} catch (SQLException e) {
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
		return ciudades;
	
	}
}
