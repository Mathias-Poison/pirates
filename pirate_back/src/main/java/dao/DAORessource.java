package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Singleton;
import model.Ressource;

abstract class DAORessource implements IDAORessource {

	@Override
	public Ressource save(Ressource ressource) {
		
		EntityManager em=null;
		EntityTransaction tx=null;
		
		try {
			
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			ressource = em.merge(ressource);
			tx.commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	
		return ressource;
	}

	private void delete() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();	
	}
	

	
}
