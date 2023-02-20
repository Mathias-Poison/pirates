package model;

public class Client extends Compte{

	protected String nom;
	protected String prenom;
	
	public Client(int id, int age, int mdp, String pseudo, String nom, String prenom) {
		super(id, age, mdp, pseudo);
		
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
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", age=" + age + ", mdp=" + mdp
				+ ", pseudo=" + pseudo + "]";
	}

}
