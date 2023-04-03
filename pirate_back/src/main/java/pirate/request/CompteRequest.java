package pirate.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CompteRequest {

	@Positive
	protected int age;
	@NotBlank
	protected String login;
	@NotBlank
	protected String password;
	@NotBlank
	protected String type_compte;
	@NotBlank
	protected String email;
	@NotBlank
	protected String pseudonyme;
	@NotBlank
	protected String nom;
	@NotBlank
	protected String prenom;
	
	
	
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
	public String getPseudonyme() {
		return pseudonyme;
	}
	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType_compte() {
		return type_compte;
	}
	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}
	
	
}
