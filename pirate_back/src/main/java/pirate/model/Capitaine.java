package pirate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import pirate.controller.api.Views;

@Entity
@DiscriminatorValue("Capitaine")
public class Capitaine extends Compte {

	@JsonView(Views.Capitaine.class)
	private String pseudonyme ;
	
	@JsonView(Views.Capitaine.class)
	private int tauxReussite ;
	
	@JsonView(Views.Capitaine.class)
	@OneToMany(mappedBy = "capitaine")
	private List<Mission> missions;
	
	@JsonView(Views.Capitaine.class)
	@OneToMany(mappedBy = "capitaine")
	private List<Enchere> encheres;
	
	public Capitaine() {

	}
	
	public Capitaine(int age,String login, String password, String pseudonyme, int tauxReussite) {
		super(age, login, password);
		
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
				+ ", login=" + login + ", mdp=" + password + ", pseudo=" + "]";
	}
	
}
