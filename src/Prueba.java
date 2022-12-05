
import java.util.Iterator;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class Prueba {
	public Prueba(){
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "persons.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Client a= new Client("7","HOLA","APELLIDO",7);
		pm.makePersistent(a);
		tx.commit();
		tx.begin();
		Iterator<Client> iterador = pm.getExtent(Client.class).iterator();
		System.out.println(iterador.next());
		tx.commit();
	}
	
	
}
