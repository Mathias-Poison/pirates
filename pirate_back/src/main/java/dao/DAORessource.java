package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Singleton;
import model.Ressource;

public class DAORessource implements IDAORessource {

	@Override
	public Ressource findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ressource ressource = em.find(Ressource.class,id);
		em.close();
		return ressource;
	}

	@Override
	public List<Ressource> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Ressource> ressourcex = em.createQuery("from Ressource").getResultList();
		em.close();
		return ressourcex;
	}

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

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ressource ressource = em.find(Ressource.class,id);
		em.getTransaction().begin();
		em.remove(ressource);
		em.getTransaction().commit();
		em.close();	
	}
	

	
}
