package pirate.request;

import jakarta.validation.constraints.NotBlank;

public class MissionRequest {

	@NotBlank
	protected int duree;
	@NotBlank
	protected String libelle;
	@NotBlank
	protected String lieu;
	@NotBlank
	protected int difficulte;
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	
	
	
	
}
