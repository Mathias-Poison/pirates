package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOBateau;
import dao.DAOCompte;
import dao.DAOEnchere;
import dao.DAOMission;
import dao.DAORessource;
import dao.IDAOBateau;
import dao.IDAOCompte;
import dao.IDAOEnchere;
import dao.IDAOMission;
import dao.IDAORessource;

public class Singleton {

	
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOBateau daoBateau = new DAOBateau();
	private IDAOEnchere daoEnchere = new DAOEnchere();
	private IDAOMission daoMission = new DAOMission();
	private IDAORessource daoRessource = new DAORessource();

	EntityManagerFactory emf= Persistence.createEntityManagerFactory("reserve");
	
	private static Singleton instance=null;
	
	private Singleton() {}

	

	public static Singleton getInstance() {
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}



	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}



	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}



	public IDAOBateau getDaoBateau() {
		return daoBateau;
	}



	public void setDaoBateau(IDAOBateau daoBateau) {
		this.daoBateau = daoBateau;
	}



	public IDAOEnchere getDaoEnchere() {
		return daoEnchere;
	}



	public void setDaoEnchere(IDAOEnchere daoEnchere) {
		this.daoEnchere = daoEnchere;
	}



	public IDAOMission getDaoMission() {
		return daoMission;
	}



	public void setDaoMission(IDAOMission daoMission) {
		this.daoMission = daoMission;
	}



	public IDAORessource getDaoRessource() {
		return daoRessource;
	}



	public void setDaoRessource(IDAORessource daoRessource) {
		this.daoRessource = daoRessource;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	
}
