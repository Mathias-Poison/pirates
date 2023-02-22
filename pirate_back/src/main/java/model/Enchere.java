package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enchere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double prix;
	private LocalDate date;
	
	private Mission missions;
	
	@ManyToOne
	@JoinColumn(name = "capitaine")
	private Capitaine capitaine;
	
	@ManyToOne
	@JoinColumn(name = "mission")
	private Mission mission;

	public Enchere() {
		// TODO Auto-generated constructor stub
	}
	
	public Enchere(double prix, LocalDate date, int id) {
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
