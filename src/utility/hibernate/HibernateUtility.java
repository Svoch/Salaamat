package utility.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * TODO remove debug and commented codes
 * @author siavashnazari and lots of online sources
 *
 */
public class HibernateUtility {
	
	 private static SessionFactory sessionFactory;
     private static StandardServiceRegistryBuilder serviceRegistryBuilder;
     
     public static SessionFactory createSessionFactory() {
    	 
			Configuration configuration = new Configuration();
			 
			 configuration
				.addResource("User.hbm.xml");
			 configuration
				.addResource("Illness.hbm.xml");
			 configuration
			 	.addResource("Medicine.hbm.xml");
			 
			 configuration.configure();
			 
			 serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			 serviceRegistryBuilder.applySettings(configuration.getProperties());
			 ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			 
			 return sessionFactory;
     }
     
     public static SessionFactory getSessionFactory() {
    	 return sessionFactory;
     }
     public static StandardServiceRegistryBuilder getServiceRegistryBuilder() {
    	 return serviceRegistryBuilder;
     }
}
