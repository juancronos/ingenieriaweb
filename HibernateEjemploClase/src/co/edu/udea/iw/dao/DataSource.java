package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Juan David Torres
 *
 */

public class DataSource {
	
	private static DataSource instance = null;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	public DataSource() {
		
	}
		
	public static DataSource getIntance(){
			if(instance == null){
				instance = new DataSource();
			}
			
			return instance;
		}
	
	public Session getSession() throws MyException{
		
		try{
		if(factory == null){
			//conf.configure("co/edu/udea/iw/dao/hibernate.cfg.xml");
			conf.configure("co/edu/udea/iw/dao/hibernate.cfg.xml");
						
			factory = conf.buildSessionFactory();
		}
		
		return factory.openSession();
		}catch(HibernateException e){
			throw new MyException("Ha ocurrido un error conectando a la base de datos usando hibernate", e);
		}
	}
		
	}


