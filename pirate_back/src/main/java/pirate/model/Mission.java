package pirate.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="mission")
public class Mission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nom",nullable = false,columnDefinition = "VARCHAR(50)")
	private String libelle;
	@Column( length = 3, nullable = false)
	private int duree;
	@Column(nullable = false,columnDefinition = "VARCHAR(50)")
	private String lieu;
	@Column(nullable = false, length = 3)
	private int difficulte;
	
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "capitaine")
	private Capitaine capitaine;
	
	@ManyToOne
	@JoinColumn(name = "client")
	private Client client;
	
	@OneToMany(mappedBy = "mission")
	private List<Enchere> encheres;
	
	@ManyToOne
	@JoinColumn(name = "ressource")
	private Bateau ressource;
	
	@Column(name="statut",columnDefinition = "ENUM('EnAttente','EnCours','Terminee')")
	@Enumerated(EnumType.STRING)
	private Statut statut;
	
	public Mission() {}
	
	public Mission(int duree, String lieu, int difficulte, String libelle, LocalDate date) {
		this.duree = duree;
		this.lieu = lieu;
		this.difficulte = difficulte;
		this.libelle = libelle;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Missions [id=" + id + ", duree=" + duree + ", lieu=" + lieu + ", difficulte=" + difficulte
				+ ", libelle=" + libelle + ", date=" + date + "]";
	}
	
	
	
}
