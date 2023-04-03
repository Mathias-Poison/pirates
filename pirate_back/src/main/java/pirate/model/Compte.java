package pirate.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import pirate.controller.api.Views;

	@Entity
	@Table(name="compte")
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('admin', 'capitaine', 'client')")
public class Compte {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	protected Integer id;
	
	@Column(length = 3,nullable = false)
	@JsonView(Views.Compte.class)
	protected int age;
	
	@Column(length = 25,nullable = false)
	@JsonView(Views.Compte.class)
	protected String login;
	
	@Column(name="password",length = 125,nullable = false)
	protected String password;
	
	@Column(name = "type_compte", insertable=false, updatable=false)
	@JsonView(Views.Compte.class )
	protected String type_compte;
	
	@Column(name = "email")
	@JsonView(Views.Compte.class)
	protected String email;

	public Compte() {
		
	}
	
	public Compte(int age, String login, String password, String type_compte, String email) {
		this.age = age;
		this.login = login;
		this.password = password;
		this.type_compte = type_compte;
		this.email = email;

		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getType_compte() {
		return type_compte;
	}

	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", age=" + age + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
