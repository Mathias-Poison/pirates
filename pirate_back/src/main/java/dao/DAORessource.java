package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Ressource;

public class DAORessource implements IDAORessource {

	@Override
	public Ressource findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ressource mission = em.find(Ressource.class,id);
		em.close();
		return mission;
	}

	@Override
	public List<Ressource> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Ressource> ressource = em.createQuery("from Ressource").getResultList();
		em.close();
		return ressource;
	}

	@Override
	public Ressource save(Ressource mission) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		mission = em.merge(mission);
		em.getTransaction().commit();
		em.close();
		return mission;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ressource mission = em.find(Ressource.class,id);
		em.getTransaction().begin();
		em.remove(mission);
		em.getTransaction().commit();
		em.close();	
	}

	
}
