package model;

import java.time.LocalDate;

public class Enchere {

	protected double prix;
	protected LocalDate date;
	
	public Enchere(double prix, LocalDate date) {
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
