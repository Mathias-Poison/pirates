package model;

public class Bateau {

	int id;

	public Bateau(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bateau [id=" + id + "]";
	}
	
	
	
}
