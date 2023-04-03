package pirate.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {

	public Admin() {
		
	}
	
	public Admin(int age, String login, String password, String type_compte, String email) {
		super(age, login, password, type_compte, email);
		
	}
	

	@Override
	public String toString() {
		return "Admin [id=" + id + ", age=" + age + ", login=" + login + ", mdp=" + password + ", pseudo=" + "]";
	}
	
}
