package pirate.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte{

	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy = "client")
	private List<Mission> missions;
	
	public Client() {

	}
	
	public Client(int age, String login, String mdp, String pseudo, String nom, String prenom) {
		super(age, login, mdp, pseudo);
		
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
				+ ", mdp=" + mdp + ", pseudo=" + pseudo + "]";
	}

	

}
