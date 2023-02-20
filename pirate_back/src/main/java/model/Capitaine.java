package model;

public class Capitaine extends Compte {

	protected String pseudonyme ;
	protected int tauxReussite ;
	
	public Capitaine(int id, int age, int mdp, String pseudo, String pseudonyme, int tauxReussite) {
		super(id, age, mdp, pseudo);
		
		this.pseudonyme = pseudonyme;
		this.tauxReussite = tauxReussite;
	}

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

	@Override
	public String toString() {
		return "Capitaine [pseudonyme=" + pseudonyme + ", tauxReussite=" + tauxReussite + ", id=" + id + ", age=" + age
				+ ", mdp=" + mdp + ", pseudo=" + pseudo + "]";
	}
	
}
