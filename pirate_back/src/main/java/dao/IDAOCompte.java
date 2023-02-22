package dao;

import java.util.List;

import model.Capitaine;
import model.Client;
import model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer>{

	public Compte findByLoginAndPassword(String login, String password);
	public List<Capitaine> findAllCapitaine();
	public List<Client> findAllClient();
}
