package friendsbets.core.sb.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().addProperties(ConfigurationUtil.getProperties()).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
//package utils;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
///**
// * Construction en une fois de la sessionFactory
// * @author gauthier
// *
// */
//public class HibernateUtils {
//
//	private static final SessionFactory SESSIONFACTORY;
//	
//	static {
//		try (var is = Files.newInputStream(Paths.get("src/main/resources/db.properties"))) {
//			Properties p = new Properties();
//			p.load(is);
//			SESSIONFACTORY = new Configuration().configure().addProperties(p).buildSessionFactory();
//		} catch (Throwable ex) {
//			System.err.println("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return SESSIONFACTORY;
//	}
//	
//}
