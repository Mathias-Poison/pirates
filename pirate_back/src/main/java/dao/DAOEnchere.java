package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Enchere;

public class DAOEnchere implements IDAOEnchere {
	@Override
	public Enchere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Enchere enchere = em.find(Enchere.class,id);
		em.close();
		return enchere;
	}
	
	@Override
	public List<Enchere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Enchere> encheres = em.createQuery("from Enchere").getResultList();
		em.close();
		return encheres;
	}

	@Override
	public Enchere save(Enchere enchere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		enchere = em.merge(enchere);
		em.getTransaction().commit();
		em.close();
		return enchere;

	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Enchere enchere = em.find(Enchere.class,id);
		em.getTransaction().begin();
		em.remove(enchere);
		em.getTransaction().commit();
		em.close();	
	}

}
