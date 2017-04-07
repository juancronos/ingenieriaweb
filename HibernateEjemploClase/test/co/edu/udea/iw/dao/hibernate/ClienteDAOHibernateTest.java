package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOHibernateTest {

	@Test
	public void test() {
		
		ClienteDAO clienteDAO = null;
		Cliente cliente = null;
		Usuario usuarioCrea = null;
		
		try{
			cliente = new Cliente();
			cliente.setCedula("1039285274");
			cliente.setNombres("Juan");
			cliente.setApellidos("Torres");
			cliente.setEmail("juandavid.torres@gmail.com");
			
			usuarioCrea = new Usuario();
			usuarioCrea.setLogin("Juan");
			
			cliente.setUsuarioCrea(usuarioCrea);
			cliente.setFechaCreacion(new Date());
			cliente.setEliminado(Boolean.FALSE);
			
			clienteDAO = new ClienteDAOHibernate();
			
			clienteDAO.insert(cliente);
		}catch(MyException e){
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}

}
