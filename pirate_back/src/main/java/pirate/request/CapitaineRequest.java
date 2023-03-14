package pirate.request;

import java.util.List;

import pirate.model.Enchere;
import pirate.model.Mission;

public class CapitaineRequest extends CompteRequest{

	
	private String pseudonyme ;
	private int tauxReussite ;
	private List<Mission> missions;
	private List<Enchere> encheres;
	
	public String getPseudonyme() {
		return pseudonyme;
	}
	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}
	public int getTauxReussite() {
		return tauxReussite;
	}
	public void setTauxReussite(int tauxReussite) {
		this.tauxReussite = tauxReussite;
	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public List<Enchere> getEncheres() {
		return encheres;
	}
	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}
}
