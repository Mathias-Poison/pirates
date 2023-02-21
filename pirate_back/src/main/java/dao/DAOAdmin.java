package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;


public class DAOAdmin implements IDAOAdmin{

	@Override
	public List<Admin> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Admin> admins = em.createQuery("from Dictateur").getResultList();
		em.close();
		return admins;
	}
	
}
