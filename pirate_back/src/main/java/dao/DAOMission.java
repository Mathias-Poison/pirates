package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Missions;

public class DAOMission implements IDAOMission {

	@Override
	public Missions findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Missions mission = em.find(Missions.class,id);
		em.close();
		return mission;
	}

	@Override
	public List<Missions> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Missions> missions = em.createQuery("from Missions").getResultList();
		em.close();
		return missions;
	}

	@Override
	public Missions save(Missions mission) {
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
		Missions mission = em.find(Missions.class,id);
		em.getTransaction().begin();
		em.remove(mission);
		em.getTransaction().commit();
		em.close();	
	}

}
