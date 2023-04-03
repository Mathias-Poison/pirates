package pirate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import pirate.controller.api.Views;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte{

	@JsonView(Views.Client.class)
	private String nom;
	@JsonView(Views.Client.class)
	private String prenom;
	
	@OneToMany(mappedBy = "client")
	//@JsonView(Views.Client.class)
	private List<Mission> missions;
	
	public Client() {

	}
	
	public Client(int age, String login, String password, String nom, String prenom, String type_compte, String email) {
		super(age, login, password, type_compte, email);
		
		this.nom = nom;
		this.prenom = prenom;
	}

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

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", age=" + age + ", login=" + login
				+ ", mdp=" + password  + "]";
	}

	

}
