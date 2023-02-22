package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {

	public Admin() {
		
	}
	
	public Admin(int age, String login, String mdp, String pseudo) {
		super(age, login, mdp, pseudo);
		
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", age=" + age + ", login=" + login + ", mdp=" + mdp + ", pseudo=" + pseudo + "]";
	}
	
}
