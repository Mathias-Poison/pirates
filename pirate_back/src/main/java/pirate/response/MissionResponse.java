package pirate.response;

import pirate.model.Bateau;
import pirate.model.Capitaine;
import pirate.model.Client;
import pirate.model.Statut;

public class MissionResponse {
	
	protected Integer id;
	protected String libelle;
	protected int duree;
	protected String lieu;
	protected int difficulte;
	protected Bateau bateau;
	protected Capitaine capitaine;
	protected Client client;
	protected Statut statut;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}
	public Bateau getBateau() {
		return bateau;
	}
	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	public Capitaine getCapitaine() {
		return capitaine;
	}
	public void setCapitaine(Capitaine capitaine) {
		this.capitaine = capitaine;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	
}
