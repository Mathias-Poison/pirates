package pirate.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Bateau {

	
	private int id;

	public Bateau() {
	}
	
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
