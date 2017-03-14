import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaCiudades {

	public static void main(String[] args) {

			consultarCiudades();	

	}
	
	public static void consultarCiudades(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/clase";
		String usuario = "Juantorres";
		String pws = "UdeA2017";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, usuario, pws);
			
			ps = con.prepareStatement("SELECT * FROM ciudades");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getLong("codigo")+ ": " + rs.getString("Nombre"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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
	}

}
