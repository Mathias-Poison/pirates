package pirate.request;

import java.util.List;

import pirate.model.Mission;

public class ClientRequest extends CompteRequest{

	private String nom;
	private String prenom;
	private List<Mission> missions;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
}
