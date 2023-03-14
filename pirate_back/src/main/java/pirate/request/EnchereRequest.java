package pirate.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import pirate.model.Capitaine;
import pirate.model.Mission;

public class EnchereRequest {

	@Positive
	private double prix;
	@NotNull
	private LocalDate date;
	@NotNull
	private Capitaine capitaine;
	@NotNull
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
