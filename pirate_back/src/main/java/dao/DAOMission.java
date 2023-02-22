package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Mission;

public class DAOMission implements IDAOMission {

	@Override
	public Mission findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Mission mission = em.find(Mission.class,id);
		em.close();
		return mission;
	}

	@Override
	public List<Mission> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Mission> missions = em.createQuery("from Missions").getResultList();
		em.close();
		return missions;
	}

	@Override
	public Mission save(Mission mission) {
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
		Mission mission = em.find(Mission.class,id);
		em.getTransaction().begin();
		em.remove(mission);
		em.getTransaction().commit();
		em.close();	
	}

}
