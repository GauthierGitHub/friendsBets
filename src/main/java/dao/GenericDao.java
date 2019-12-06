package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 
 * @author Gauthier Barbet
 *
 * @param <T>
 */
public class GenericDao<T> {

	protected List<T> database = new ArrayList<T>();

	public void save(T t) {
		database.add(t);
	}

	public void delete(T t) {
		database.remove(t);
	}
/**
 * a refaire
 * @param t
 * @param index
 */
	public void update(T t, int index) {
		database.set(index, t);
	}

	public List<T> findAll() {
		return database;
	}

	public List<T> findBy(Predicate<T> predicate) {
		List<T> lt = new ArrayList<T>(); 
		lt = database.stream()
				.filter(predicate)
				.collect(Collectors.toList());
		return lt;
	}
	
	// TODO findOne
//	public T findOne(Predicate<T> predicate) {
//		T t = database.stream()
//				.findFirst(predicate)
//				.collect(Collectors.toList());
//		return lt;
//	}
}
