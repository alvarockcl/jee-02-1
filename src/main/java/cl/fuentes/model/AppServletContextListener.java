package cl.fuentes.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppServletContextListener implements ServletContextListener {

	  private static EntityManagerFactory emf;

	    public void contextInitialized(ServletContextEvent event) {
	        emf = Persistence.createEntityManagerFactory("jee02PU");
	        createEntityManager();
	    }

	    public void contextDestroyed(ServletContextEvent event) {
	        emf.close();
	    }

	    public static EntityManager createEntityManager() {
	        if (emf == null) {
	            throw new IllegalStateException("Context is not initialized yet.");
	        }

	        return emf.createEntityManager();
	    }
	
}
