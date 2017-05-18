package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOHibernate implements ClienteDAO{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> get() throws MyException {
		
		Session session = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		Criteria criteria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			
			clientes = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Ocurrio Error consultando los clientes en la base de datos", e);
		}
		
		return clientes;
	}

	@Override
	public void insert(Cliente cliente) throws MyException {
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			session.save(cliente);
			transaction.commit();
			
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio Error insertando un cliente en la base de datos", e);
		}
		
	}

	@Override
	public Cliente get(String cedula) throws MyException {
		Session session = null;
		Cliente cliente = null;
		
		
		try{
			session = sessionFactory.getCurrentSession();
			
			cliente = (Cliente) session.get(Cliente.class, cedula);
		}catch(HibernateException e){
			throw new MyException("Ocurrio Error consultando los clientes en la base de datos", e);
		}
		
		return cliente;
	}

	@Override
	public void update(Cliente cliente) throws MyException {
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			session.update(cliente);
			transaction.commit();
			
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio Error insertando un cliente en la base de datos", e);
		}
		
	}

}
