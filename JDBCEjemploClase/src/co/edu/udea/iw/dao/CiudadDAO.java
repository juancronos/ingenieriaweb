package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public interface CiudadDAO {

	public List<Ciudad> get() throws MyException;	
	
}
