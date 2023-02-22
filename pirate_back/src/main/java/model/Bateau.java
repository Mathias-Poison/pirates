package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bateau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

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
