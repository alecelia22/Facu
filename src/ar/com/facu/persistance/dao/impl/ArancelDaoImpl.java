package ar.com.facu.persistance.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.com.facu.entidades.Arancel;
import ar.com.facu.entidades.util.HibernateUtil;

public class ArancelDaoImpl {

	private Session session;

	/**
	 * Busco todos los aranceles.
	 */
	public List<Arancel> buscarAranceles() {
		// Creo una nueva session de BBDD 
		session = HibernateUtil.getSession();
		// Criterio de busqueda
		Criteria arancelCriteria = session.createCriteria(Arancel.class);
		// Busco a todos los aranceles
		@SuppressWarnings("unchecked")
		List<Arancel> aranceles = arancelCriteria.list();

		// Cierro la session
		session.close();

		return aranceles;
	}

	/**
	 * Guardo o actualizo un arancel.
	 */
	public void guardar(Arancel arancel) {
		session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(arancel);
		transaction.commit();
		session.close();		
	}
}
