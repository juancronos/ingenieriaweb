package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Interface con los metodos DAO para usuarios
 * @author Juan David Torres - Juandavid.torres@gmail.com
 *
 */
public interface UsuarioDAO {
	
	public Usuario get(String login) throws MyException;
}
