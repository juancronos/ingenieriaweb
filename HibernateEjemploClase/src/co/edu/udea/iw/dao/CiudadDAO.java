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
 * Metodo para consultar todas las ciudades en la base de Datos
 * @return este metodo retorna una lista de ciudades
 * @throws MyException si sucede un error se lanza una excepcion de tipo Myexception
 */
	public List<Ciudad> get() throws MyException;
	
	/**
	 * Metodo para buscar una ciudad dentro de la base de datos
	 * @param codigo Codigo de la ciudad que se quiere buscar
	 * @return Un objeto Ciudad con los datos de la ciudad solicitada
	 * @throws MyException Ocurre cuando un error consultando la base de datos
	 */
	public Ciudad get(Long codigo) throws MyException;
	
	/**
	 * Metodo para Insertar una nueva ciudad a la Base de Datos
	 * @param ciudad Un objeto tipo ciudad que se va a insertar a la base de datos
	 * @throws MyException Ocurre cuando un error insertando en la base de datos
	 */
	public void insert(Ciudad ciudad) throws MyException;
	
	/**
	 * Metodo para actualizar una ciudad en la base de datos
	 * @param ciudad Un objeto tipo ciudad que se va a actualizar en la base de datos
	 * @throws MyException Ocurre cuando un error actualizando en la base de datos
	 */
	public void update(Ciudad ciudad) throws MyException;
	
	/**
	 * Metodo que elimina una ciudad de la base de datos
	 * @param ciudad ciudad que se dese eliminar
	 * @throws MyException Ocurre cuando un error borrando en la base de datos
	 */
	public void delete(Ciudad ciudad) throws MyException;
	
}
