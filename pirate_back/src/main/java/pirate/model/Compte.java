package pirate.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

	@Entity
	@Table(name="compte")
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('admin', 'capitaine', 'client')")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length = 3,nullable = false)
	protected int age;
	@Column(length = 25,nullable = false)
	protected String login;
	@Column(name="password",length = 125,nullable = false)
	protected String password;
	@Column(length = 50,nullable = false)
	protected String pseudo;
	
	public Compte() {
		
	}
	
	public Compte(int age, String login, String password, String pseudo) {
		this.age = age;
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", age=" + age + ", login=" + login + ", password=" + password + ", pseudo=" + pseudo + "]";
	}
	
	
}
