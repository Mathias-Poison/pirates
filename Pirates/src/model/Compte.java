package model;

public class Compte {

	protected int id;
	protected int age;
	protected int mdp;
	protected String pseudo;
	
	public Compte(int id, int age, int mdp, String pseudo) {
		this.id = id;
		this.age = age;
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

	public int getMdp() {
		return mdp;
	}

	public void setMdp(int mdp) {
		this.mdp = mdp;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
}
