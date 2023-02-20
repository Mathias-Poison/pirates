package model;

public class Ressource {

	private Cargaison cargaison;
	private Armement armement;
	private Bateau bateau;
	
	public Ressource(Cargaison cargaison, Armement armement, Bateau bateau) {
		this.cargaison = cargaison;
		this.armement = armement;
		this.bateau = bateau;
		
		
		
	}

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}

	public Armement getArmement() {
		return armement;
	}

	public void setArmement(Armement armement) {
		this.armement = armement;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public String toString() {
		return "Ressource [cargaison=" + cargaison + ", armement=" + armement + ", bateau=" + bateau + "]";
	}
		
	
	
}
