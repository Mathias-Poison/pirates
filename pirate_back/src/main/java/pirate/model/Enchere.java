package pirate.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pirate.controller.api.Views;

@Entity
public class Enchere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@JsonView({Views.Enchere.class, Views.Capitaine.class, Views.Client.class})
	private double prix;
	@JsonView({Views.Enchere.class, Views.Capitaine.class, Views.Client.class})
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "capitaine")
	@JsonView(Views.Enchere.class)
	private Capitaine capitaine;
	
	@ManyToOne
	@JoinColumn(name = "mission")
	@JsonView({Views.Enchere.class, Views.Capitaine.class, Views.Client.class})
	private Mission mission;

	public Enchere() {
	}
	
	
	public Enchere(Integer id, double prix, LocalDate date, Capitaine capitaine, Mission mission) {
		super();
		this.id = id;
		this.prix = prix;
		this.date = date;
		this.capitaine = capitaine;
		this.mission = mission;
	}


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


	@Override
	public String toString() {
		return "Enchere [id=" + id + ", prix=" + prix + ", date=" + date + ", capitaine=" + capitaine + ", mission="
				+ mission + "]";
	}


	
	
	
}
