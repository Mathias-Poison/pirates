package test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestMapping {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pirate");
		
	
		emf.close();
	}
	//Tes grands morts Mathias

}
