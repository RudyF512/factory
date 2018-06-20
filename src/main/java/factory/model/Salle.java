package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Salle")
public class Salle extends RMaterielle {

	@Column(name = "nom_salle")
	@JsonView(Views.ViewRMaterielle.class)
	private String nomSalle;

	@Column(name = "capacite")
	@JsonView(Views.ViewRMaterielle.class)
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

	public Salle(String code, Long cout, Boolean dispo, String nomSalle, Integer capacite) {
		super(code, cout, dispo);
		this.nomSalle = nomSalle;
		this.capacite = capacite;
	}

	public Salle() {
		super();
	}

}
