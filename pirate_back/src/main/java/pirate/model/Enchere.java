package pirate.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enchere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double prix;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "capitaine")
	private Capitaine capitaine;
	
	@ManyToOne
	@JoinColumn(name = "mission")
	private Mission mission;

	public Enchere() {
		// TODO Auto-generated constructor stub
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