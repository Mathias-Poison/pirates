package pirate.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import pirate.model.Armement;
import pirate.model.Cargaison;
import pirate.model.Mission;

public class BateauRequest {
	
	private Integer id;
	@NotBlank
	private String nom;
	private Cargaison cargaison;
	private Armement armement;
	private List<Mission> missions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	

}
