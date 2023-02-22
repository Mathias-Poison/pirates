package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Bateau;

public class DAOBateau implements IDAOBateau {
	@Override

	public Bateau findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Bateau bateau = em.find(Bateau.class,id);
		em.close();
		return bateau;
	}

	@Override
	public List<Bateau> findAll() {

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Bateau> bateaux = em.createQuery("from Bateau").getResultList();
		em.close();
		return bateaux;

	}

	@Override
	public Bateau save(Bateau bateau) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		bateau = em.merge(bateau);
		em.getTransaction().commit();
		em.close();
		return bateau;
	}

	@Override
	public void delete(Integer id) {

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Bateau bateau = em.find(Bateau.class,id);
		em.getTransaction().begin();
		em.remove(bateau);
		em.getTransaction().commit();
		em.close();	

	}
}
