package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Capitaine;
import model.Client;
import model.Compte;

public class DAOCompte implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class,id);
		em.close();
		return compte;
	}
	
	@Override
	public List<Compte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Compte> comptes = em.createQuery("from Compte").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte save(Compte compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		compte = em.merge(compte);
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class,id);
		em.getTransaction().begin();
		em.remove(compte);
		em.getTransaction().commit();
		em.close();	
	}
	
	@Override
	public Compte findByLoginAndPassword(String login, String password) {
		Compte connected = null;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		try 
		{
			Query q = em.createQuery("from Compte c where c.login=:login and c.password=:password");
			q.setParameter("login", login);
			q.setParameter("password", password);
			connected = (Compte) q.getSingleResult();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return connected;
	}

	@Override
	public List<Capitaine> findAllCapitaine() {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		String type = "ranger";
		List<Capitaine> capitaines = em.createQuery("from Compte c where c.type_compte=:type").setParameter("type",type).getResultList();
		em.close();
		return capitaines;
	}

	@Override
	public List<Client> findAllClient() {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		String type = "client";
		List<Client> clients = em.createQuery("from Compte c where c.type_compte=:type").setParameter("type",type).getResultList();
		em.close();
		return clients;
	}
}
