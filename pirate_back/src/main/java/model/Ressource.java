package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("ressource")
public class Ressource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cargaison",columnDefinition = "ENUM('petite','moyenne','grande')")
	@Enumerated(EnumType.STRING)
	private Cargaison cargaison;
	@Column(name="armement",columnDefinition = "ENUM('leger','moyen','lourd')")
	@Enumerated(EnumType.STRING)
	private Armement armement;
	@Embedded
	private Bateau bateau;
	
	@OneToMany(mappedBy = "ressource")
		private List<Mission> missions;
	
	public Ressource() {

	}
	
	public Ressource(Cargaison cargaison, Armement armement, Bateau bateau) {
		this.cargaison = cargaison;
		this.armement = armement;
		this.bateau = bateau;
		
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

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	@Override
	public String toString() {
		return "Ressource [id=" + id + ", cargaison=" + cargaison + ", armement=" + armement + ", bateau=" + bateau
				+ ", missions=" + missions + "]";
	}


	
}
