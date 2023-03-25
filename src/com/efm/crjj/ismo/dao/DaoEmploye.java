package com.efm.crjj.ismo.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.efm.crjj.ismo.model.Employe;

import ma.ismo.crjj.utils.HibernateUtils;

public class DaoEmploye implements IDao<Employe> {

	@Override
	public List<Employe> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t =  (Transaction) s.beginTransaction();
		List<Employe> Employe = s.createQuery("from T_Employe").getResultList();
		try {
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		s.close();
		return Employe;
	}

	@Override
	public Employe getOne(int id) {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = (Transaction) s.beginTransaction();
		return s.get(Employe.class, id);
	}

	@Override
	public boolean save(Employe obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = (Transaction) session.beginTransaction();

			Object o = session.save(obj);

			System.out.println(o);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Employe obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = (Transaction) session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
