package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * DAO = just CRUD
 * @author Gauthier Barbet
 *
 * @param <T>
 */
public class GenericDao<T> {

	private Class<T> clazz;

	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T findById(Session s, int id) {
		return s.get(clazz, id);
	}

	public T findById(int id) {
		Session s = HibernateUtils.getSessionfactory().openSession();
		T p = findById(s, id);
		s.close();
		return p;
	}

	public List<T> findAll(Session s) {
		return s.createQuery("FROM " + clazz.getName(), clazz).getResultList();
	}

	public List<T> findAll() {
		Session s = HibernateUtils.getSessionfactory().openSession();
		List<T> ps = findAll(s);
		s.close();
		return ps;
	}

	public void save(Session s, Transaction t, T p) throws Exception {
		s.save(p);
	}

	public void save(Session s, T p) throws Exception {
		Transaction t = s.beginTransaction();
		try {
			save(s, t, p);
			t.commit();
		} catch (Exception e) {
			if (t != null)
				t.rollback();
			throw e;
		}
	}

	public void save(T p) throws Exception {
		Session s = HibernateUtils.getSessionfactory().openSession();
		save(s, p);
		s.close();
	}

	public void update(Session s, Transaction t, T p) {
		s.update(p);
	}

	public void update(Session s, T p) throws Exception {
		Transaction t = s.beginTransaction();
		try {
			update(s, t, p);
			t.commit();
		} catch (Exception e) {
			if (t != null)
				t.rollback();
			throw e;
		}
	}

	public void update(T p) throws Exception {
		Session s = HibernateUtils.getSessionfactory().openSession();
		update(s, p);
		s.close();
	}

	public void delete(Session s, Transaction t, T p) {
		s.delete(p);
	}

	public void delete(Session s, T p) throws Exception {
		Transaction t = s.beginTransaction();
		try {
			delete(s, t, p);
			t.commit();
		} catch (Exception e) {
			if (t != null)
				t.rollback();
			throw e;
		}
	}

	public void delete(T p) throws Exception {
		Session s = HibernateUtils.getSessionfactory().openSession();
		delete(s, p);
		s.close();
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
}
