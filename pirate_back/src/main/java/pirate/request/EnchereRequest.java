package pirate.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import pirate.model.Capitaine;
import pirate.model.Mission;

public class EnchereRequest {

	@NotBlank
	private double prix;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private Capitaine capitaine;
	@NotBlank
	private Mission mission;
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Capitaine getCapitaine() {
		return capitaine;
	}
	public void setCapitaine(Capitaine capitaine) {
		this.capitaine = capitaine;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}

	
	
}
