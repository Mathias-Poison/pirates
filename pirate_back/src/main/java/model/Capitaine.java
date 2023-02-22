package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Capitaine")
public class Capitaine extends Compte {

	private String pseudonyme ;
	private int tauxReussite ;
	
	@OneToMany(mappedBy = "capitaine")
	private List<Mission> missions;
	
	@OneToMany(mappedBy = "capitaine")
	private List<Enchere> encheres;
	
	public Capitaine() {

	}
	
	public Capitaine(int age,String login, String mdp, String pseudo, String pseudonyme, int tauxReussite) {
		super(age, login, mdp, pseudo);
		
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
				+ ", login=" + login + ", mdp=" + mdp + ", pseudo=" + pseudo + "]";
	}
	
}
