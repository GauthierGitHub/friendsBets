package dao;

import java.util.function.Function;


/**
 * 
 * @author barbet
 * @param <R>
 *
 */
public interface IGenericDao<T, R> {
	void add(T t);
	void update(T t, int i);
	/**
	 * write delete = true in db
	 */
	void delete(T t);
	void findAll();
	void findBy(Function<T, R> function);
}
