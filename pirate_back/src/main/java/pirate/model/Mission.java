package pirate.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pirate.controller.api.Views;

@Entity
@Table(name="mission")
public class Mission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({Views.Mission.class,Views.Capitaine.class})
	private Integer id;
	
	@Column(name="libelle",nullable = false,columnDefinition = "VARCHAR(50)")
	@JsonView(Views.Mission.class)
	private String libelle;
	
	@Column( length = 3, nullable = false)
	@JsonView(Views.Mission.class)
	private int duree;
	
	@Column(nullable = false,columnDefinition = "VARCHAR(50)")
	@JsonView(Views.Mission.class)
	private String lieu;
	
	@Column(nullable = false, length = 3)
	@JsonView(Views.Mission.class)
	private int difficulte;
	
	@JsonView(Views.Mission.class)
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "capitaine")
	@JsonView(Views.Mission.class)
	private Capitaine capitaine;
	
	@ManyToOne
	@JoinColumn(name = "client")
	@JsonView(Views.Mission.class)
	private Client client;
	
	@OneToMany(mappedBy = "mission")
	@JsonView(Views.Mission.class)
	private List<Enchere> encheres;
	
	@ManyToOne
	@JoinColumn(name = "bateau")
	@JsonView(Views.Mission.class)
	private Bateau bateau;
	
	@Column(name="statut",columnDefinition = "ENUM('EnAttente','EnCours','Terminee')")
	@Enumerated(EnumType.STRING)
	@JsonView(Views.Mission.class)
	private Statut statut;
	
	public Mission() {}

	public Mission(Integer id, String libelle, int duree, String lieu, int difficulte, LocalDate date,
			Capitaine capitaine, Client client, List<Enchere> encheres, Bateau bateau, Statut statut) {
		this.id = id;
		this.libelle = libelle;
		this.duree = duree;
		this.lieu = lieu;
		this.difficulte = difficulte;
		this.date = date;
		this.capitaine = capitaine;
		this.client = client;
		this.encheres = encheres;
		this.bateau = bateau;
		this.statut = statut;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", libelle=" + libelle + ", duree=" + duree + ", lieu=" + lieu + ", difficulte="
				+ difficulte + ", date=" + date + ", capitaine=" + capitaine + ", client=" + client + ", encheres="
				+ encheres + ", bateau=" + bateau + ", statut=" + statut + "]";
	}
	
	
	}
