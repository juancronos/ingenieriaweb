package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Juan
 * @version 1.0
 * Esta es una interfaz que establece los metodos que tendran las clase que la implementen
 */
public interface CiudadDAO {
/**
 * 
 * @return este metodo retorna una lista de ciudades
 * @throws MyException si sucede un error se lanza una excepcion de tipo Myexception
 */
	public List<Ciudad> get() throws MyException;	
	
}
