package pirate.response;

import java.time.LocalDate;

import pirate.model.Capitaine;
import pirate.model.Mission;

public class EnchereResponse {

	private Integer id;
	private double prix;
	private LocalDate date;
	private Capitaine capitaine;
	private Mission mission;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
