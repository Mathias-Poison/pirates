package pirate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pirate.model.Capitaine;
import pirate.model.Client;
import pirate.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte, Integer>{

	public Compte findByLoginAndPassword(String login, String password);
	
	@Query("select c from Compte c where type_compte = ?1")
	public List<Capitaine> findAllCapitaine();
	
	@Query("select c from Compte c where type_compte = ?1")
	public List<Client> findAllClient();
}
