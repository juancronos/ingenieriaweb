package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOHibernate<ciudades> implements CiudadDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> get() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		try{
			session = DataSource.getIntance().getSession();
			criteria = session.createCriteria(Ciudad.class);
			
			
			ciudades = criteria.list();
		
		}catch(HibernateException e){
			throw new MyException("Se encontraron Errores consultando las ciudades", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		return ciudades;
	}

	@Override
	public Ciudad get(Long codigo) throws MyException {
		Session session = null;		
		Ciudad ciudad = null;
		
		try{
			session = DataSource.getIntance().getSession();
			
			ciudad = (Ciudad) session.get(Ciudad.class, codigo);
		
		}catch(HibernateException e){
			throw new MyException("Se encontraron Errores consultando la ciudad por medio del codigo", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		return ciudad;
	}

	@Override
	public void insert(Ciudad ciudad) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getIntance().getSession();
			tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error Gurdando la ciudad en la base de Datos", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	@Override
	public void update(Ciudad ciudad) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getIntance().getSession();
			tx = session.beginTransaction();
			session.update(ciudad);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error Gurdando la ciudad en la base de Datos", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	@Override
	public void delete(Ciudad ciudad) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getIntance().getSession();
			tx = session.beginTransaction();
			session.delete(ciudad);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error Gurdando la ciudad en la base de Datos", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	
}
