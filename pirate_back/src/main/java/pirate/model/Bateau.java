package pirate.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Bateau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="cargaison",columnDefinition = "ENUM('petite','moyenne','grande')")
	@Enumerated(EnumType.STRING)
	private Cargaison cargaison;
	
	@Column(name="armement",columnDefinition = "ENUM('leger','moyen','lourd')")
	@Enumerated(EnumType.STRING)	
	private Armement armement;
	
	@OneToMany(mappedBy ="bateau" )
	private List<Mission> missions;
	
	public Bateau() {

	}
	
	public Bateau(Cargaison cargaison, Armement armement, String nom) {
		this.cargaison = cargaison;
		this.armement = armement;
		this.nom= nom;
		
	}

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}

	public Armement getArmement() {
		return armement;
	}

	public void setArmement(Armement armement) {
		this.armement = armement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Ressource [id=" + id + ", cargaison=" + cargaison + ", armement=" + armement + ", bateau=" + nom
				+ ", missions=" + missions + "]";
	}


	
}
