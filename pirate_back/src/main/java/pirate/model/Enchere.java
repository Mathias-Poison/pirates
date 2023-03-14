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
	@JsonView({Views.Enchere.class, Views.Capitaine.class, Views.Client.class})
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
	
	public Enchere(double prix, LocalDate date, Integer id) {
		this.prix = prix;
		this.date = date;
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

	@Override
	public String toString() {
		return "Enchere [prix=" + prix + ", date=" + date + "]";
	}
	
	
	
}
