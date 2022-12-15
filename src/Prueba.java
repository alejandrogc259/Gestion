
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class Prueba {
	public Prueba(){
		
	}
	public static void anadirClient() {
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Client a= new Client("7","HOLA","APELLIDO",7);
		pm.makePersistent(a);
		tx.commit();
		/*
		 * tx.begin(); Iterator<Client> iterador =
		 * pm.getExtent(Client.class).iterator(); System.out.println(iterador.next());
		 * tx.commit();
		 */
	}
	public static List<Client> obtenerClients(){
		List<Client> clientes = new ArrayList<Client>();
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Client> iterador = pm.getExtent(Client.class).iterator();
		while(iterador.hasNext())
		{
			clientes.add(iterador.next());
		}
		return clientes;
	}
	public static boolean anadirClient(Client a) {
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Client> iterador = pm.getExtent(Client.class).iterator();
		boolean encontrado=false;
		while(iterador.hasNext())
		{
			Client x = iterador.next();
			if(x.getNIF().equals(a.getNIF())) {
				encontrado=true;
			}
		}
		if(!encontrado)pm.makePersistent(a);
		tx.commit();
		return !encontrado;
	}
	public static void BorrarClient(String NIF) {
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Client> iterador = pm.getExtent(Client.class).iterator();
		while(iterador.hasNext())
		{
			Client x = iterador.next();
			if(x.getNIF().equals(NIF)) {
				pm.deletePersistent(x);
			}
		}
		tx.commit();
		
	}
	public static void ActualizarClient(String NIF,Client a) {
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Client> iterador = pm.getExtent(Client.class).iterator();
		while(iterador.hasNext())
		{
			Client x = iterador.next();
			if(x.getNIF().equals(NIF)) {
				x.setNIF(a.getNIF());
				x.setNombre(a.getNombre());
				x.setApellidos(a.getApellidos());
				x.setEdad(a.getEdad());
			}
		}
		tx.commit();
		
	}
	public static List<Revision> obtenerRevisiones(){
		List<Revision> revisiones = new ArrayList<Revision>();
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Revision> iterador = pm.getExtent(Revision.class).iterator();
		while(iterador.hasNext())
		{
			revisiones.add(iterador.next());
		}
		return revisiones;
	}
	public static int obtenerID() {
		int id=0;
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Revision> iterador = pm.getExtent(Revision.class).iterator();
		while(iterador.hasNext())
		{
			id=iterador.next().getID();
		}
		return id;
	}
	public static void anadirRevision(Revision a) {
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "lol.odb");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(a);
		tx.commit();
	}
	
	
}
