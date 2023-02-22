package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
	@Column(length = 125,nullable = false)
	protected String mdp;
	@Column(length = 50,nullable = false)
	protected String pseudo;
	
	public Compte() {
		
	}
	
	public Compte(int age, String login, String mdp, String pseudo) {
		this.age = age;
		this.login = login;
		this.mdp = mdp;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", age=" + age + ", login=" + login + ", mdp=" + mdp + ", pseudo=" + pseudo + "]";
	}
	
	
}
