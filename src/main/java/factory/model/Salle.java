package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Salle")
public class Salle extends RMaterielle {

	public Salle(Long id, String code, Long cout, Boolean dispo, String nomSalle, Integer capacite) {
		super(id, code, cout, dispo);
		this.nomSalle = nomSalle;
		this.capacite = capacite;
	}

	public Salle() {
		super();
	}

	@Column(name = "nom_salle")
	private String nomSalle;

	@Column(name = "capacite")
	private Integer capacite;

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

}
