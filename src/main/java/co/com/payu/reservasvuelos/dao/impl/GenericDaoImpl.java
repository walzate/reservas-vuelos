package co.com.payu.reservasvuelos.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import co.com.payu.reservasvuelos.dao.GenericDao;

/**
 * Clase abstracta encargada de implementar las acciones por defecto del DAO
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 7:53:02 AM
 *
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	/**
	 * Inyección de la fábrica de sesiones
	 */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * La clase del objeto genérico∫
	 */
	private final Class<T> genericType;

	/**
	 * Gestor de la bitácora de eventos
	 */
	final static Logger LOGGER = Logger.getLogger(GenericDaoImpl.class);

	/**
	 * Método constructor de la clase GenericDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericDaoImpl.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.dao.PasajeroDao#insertRow(com.payulatam.
	 * simuladorbanco.model.Pasajero)
	 */
	@Override
	@Transactional
	public int insertRow(T entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entity);
		tx.commit();
		Serializable id = session.getIdentifier(entity);
		session.close();
		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.dao.PasajeroDao#getList()
	 */
	@Override
	public List<T> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<T> resultList = session.createQuery("from " + this.genericType.getName()).list();
		session.close();
		return resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.dao.PasajeroDao#getRowById(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getRowById(int id) {
		Session session = sessionFactory.openSession();
		T result = null;
		try {
			result = (T) session.load(Class.forName(this.genericType.getName()), id);
		} catch (ClassNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.dao.PasajeroDao#updateRow(com.payulatam.
	 * simuladorbanco.model.Pasajero)
	 */
	@Override
	public int updateRow(T entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entity);
		tx.commit();
		Serializable id = session.getIdentifier(entity);
		session.close();
		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.dao.PasajeroDao#deleteRow(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		T entity;
		Serializable ids = null;
		try {
			entity = (T) session.load(Class.forName(this.genericType.getName()), id);
			session.delete(entity);
			tx.commit();
			ids = session.getIdentifier(entity);
			session.close();
		} catch (ClassNotFoundException e) {
			LOGGER.error(e.getMessage());
		}

		return (Integer) ids;
	}

}
