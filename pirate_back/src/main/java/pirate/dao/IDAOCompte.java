package pirate.dao;

import java.util.List;

import pirate.model.Capitaine;
import pirate.model.Client;
import pirate.model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer>{

	public Compte findByLoginAndPassword(String login, String password);
	public List<Capitaine> findAllCapitaine();
	public List<Client> findAllClient();
}
