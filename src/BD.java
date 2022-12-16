
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


public class BD {
	static Properties prop;
	public BD(){
		prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
		prop.setProperty("javax.jdo.option.ConnectionURL", "revisiones.odb");
	}
	public static List<Client> obtenerClients(){
		List<Client> clientes = new ArrayList<Client>();
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
	public static List<Revision> obtenerRevisiones(String NIF){
		List<Revision> revisiones = new ArrayList<Revision>();
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Revision> iterador = pm.getExtent(Revision.class).iterator();
		while(iterador.hasNext())
		{
			Revision r = iterador.next();
			if(r.getNIF().equals(NIF)) {
				revisiones.add(r);
			}
		}
		return revisiones;
	}
	public static int obtenerID() {
		int id=1;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Revision> iterador = pm.getExtent(Revision.class).iterator();
		while(iterador.hasNext())
		{
			id=iterador.next().getID();
			id++;
		}
		return id;
	}
	public static void anadirRevision(Revision a) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(a);
		tx.commit();
	}
	
	public static void BorrarRevision(int ID) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Revision> iterador = pm.getExtent(Revision.class).iterator();
		while(iterador.hasNext())
		{
			Revision x = iterador.next();
			if(x.getID() == ID) {
				pm.deletePersistent(x);
			}
		}
		tx.commit();
	}
	
	public static void ActualizarRevision(int ID,Revision a) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		Iterator<Revision> iterador = pm.getExtent(Revision.class).iterator();
		while(iterador.hasNext())
		{
			Revision x = iterador.next();
			if(x.getID() == ID) {
				x.setConsulta(a.getConsulta());
				x.setOD_Esfera(a.getOD_Esfera());
				x.setOD_Cilindro(a.getOD_Cilindro());
				x.setOD_Adicion(a.getOD_Adicion());
				x.setOD_Agudeza(a.getOD_Agudeza());
				x.setOI_Esfera(a.getOI_Esfera());
				x.setOI_Cilindro(a.getOI_Cilindro());
				x.setOI_Adicion(a.getOI_Adicion());
				x.setOI_Agudeza(a.getOI_Agudeza());
			}
		}
		tx.commit();
		
	}
	
	
}
