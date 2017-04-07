package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.hibernate.CiudadDAOHibernate;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Juan David Torres
 * @version 1.0
 * Esta clase se usa para probar el funcionamiento del 
 * porgrama que se conecta a la base de datos y muestra las ciudades
 */
public class CiudadDAOImplTest {

	@Test
	public void testGet() {

		CiudadDAO ciudadDAO = null;
		List<Ciudad> ciudades = null;
		
		try {
			ciudadDAO = new CiudadDAOHibernate<Object>();
			ciudades = ciudadDAO.get();
			
			for(Ciudad ciudad : ciudades){
				System.out.println(ciudad.getCodigo() + " : " + ciudad.getNombre());
			}
			
			assertTrue(ciudades.size()>0);
			
		} catch (MyException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testGetUno(){
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		
		try {
			ciudadDAO = new CiudadDAOHibernate<Object>();
			ciudad = ciudadDAO.get((long) 2);
			
			System.out.println(ciudad.getCodigo() + " : " + ciudad.getNombre());
						
			assertNotNull(ciudad);
			
		} catch (MyException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void testInsert(){
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = new Ciudad();
		
		try{
			ciudad.setCodigo((long) 15);
			ciudad.setNombre("Villavicencio");
			ciudad.setCodigoArea("0452");
			
			ciudadDAO = new CiudadDAOHibernate<Object>();
			ciudadDAO.insert(ciudad);
		}catch (MyException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
