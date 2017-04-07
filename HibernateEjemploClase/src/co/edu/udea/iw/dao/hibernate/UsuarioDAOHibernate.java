package co.edu.udea.iw.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOHibernate implements UsuarioDAO {

	@Override
	public Usuario get(String login) throws MyException {
		Session session = null;
		Usuario usuario = null;
		
		try{
			session = DataSource.getIntance().getSession();
			
			usuario = (Usuario) session.get(Usuario.class, login);
			
			System.out.println(usuario.getNombres() + " : " + usuario.getRol().getNombre());
		}catch(HibernateException e){
			throw new MyException("Hubo un error consultando un usuario en la Base de Datos", e);
		}
		return usuario;
	}

}
