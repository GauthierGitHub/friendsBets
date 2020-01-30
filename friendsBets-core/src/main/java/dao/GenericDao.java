package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * DAO = just CRUD
 * exceptions like hibernateExceptions are caught in service layer so no Exception are thrown here
 * this class use constant SESSIONFACTORY build in our utils.HibernateUtils
 * instance variable clazz needed by hybernate query
 * @author Gauthier Barbet
 *
 */
public abstract class GenericDao<T> {

	private Class<T> clazz;

	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T findById(Session s, int id) {
		return s.get(clazz, id);
	}

	public T findById(int id) {
		Session s = HibernateUtils.getSessionFactory().openSession();
		T p = findById(s, id);
		s.close();
		return p;
	}

	public List<T> findAll(Session s) {
		return s.createQuery("FROM " + clazz.getName(), clazz).getResultList();
	}

	public List<T> findAll() {
		Session s = HibernateUtils.getSessionFactory().openSession();
		List<T> ps = findAll(s);
		s.close();
		return ps;
	}

	public void save(Session s, Transaction t, T p) {
		s.save(p);
	}

	public void save(Session s, T p) {
		Transaction t = s.beginTransaction();
		try {
			save(s, t, p);
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
			throw e;
		}
	}

	public void save(T p) {
		Session s = HibernateUtils.getSessionFactory().openSession();
		save(s, p);
		s.close();
	}

	public void update(Session s, Transaction t, T p) {
		s.update(p);
	}

	public void update(Session s, T p) {
		Transaction t = s.beginTransaction();
		try {
			update(s, t, p);
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
			throw e;
		}
	}

	public void update(T p) {
		Session s = HibernateUtils.getSessionFactory().openSession();
		update(s, p);
		s.close();
	}

	public void delete(Session s, Transaction t, T p) {
		s.delete(p);
	}

	public void delete(Session s, T p) {
		Transaction t = s.beginTransaction();
		try {
			delete(s, t, p);
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
			throw e;
		}
	}

	public void delete(T p) {
		Session s = HibernateUtils.getSessionFactory().openSession();
		delete(s, p);
		s.close();
	}

}

	// TODO old version
//	public List<T> findBy(Predicate<T> predicate) {
//		List<T> lt = new ArrayList<T>(); 
//		lt = database.stream()
//				.filter(predicate)
//				.collect(Collectors.toList());
//		return lt;
//	}
//	public T findOne(Predicate<T> predicate) {
//		T t = database.stream()
//				.findFirst(predicate)
//				.collect(Collectors.toList());
//		return lt;
//	}

