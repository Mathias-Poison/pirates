package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Admin;

public class DAOAdmin implements IDAOAdmin{

	@Override
	public Admin findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Admin admin = em.find(Admin.class,id);
		em.close();
		return admin;
	}
	
	@Override
	public List<Admin> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Admin> admins = em.createQuery("from Dictateur").getResultList();
		em.close();
		return admins;
	}

	@Override
	public Admin save(Admin admin) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		admin = em.merge(admin);
		em.getTransaction().commit();
		em.close();
		return admin;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Admin admin = em.find(Admin.class,id);
		em.getTransaction().begin();
		em.remove(admin);
		em.getTransaction().commit();
		em.close();	
	}
}
