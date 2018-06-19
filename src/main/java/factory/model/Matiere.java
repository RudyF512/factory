package factory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Matiere {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewRHumaine.class)
	private Long id;
	@JsonView(Views.ViewRHumaine.class)
	private String nom;
	@JsonView(Views.ViewRHumaine.class)
	private Integer duree;
	@JsonView(Views.ViewRHumaine.class)
	private String objectif;
	@JsonView(Views.ViewRHumaine.class)
	private String prerequis;
	@JsonView(Views.ViewRHumaine.class)
	private String contenue;

	public Matiere() {
		super();
	}

	public Matiere(Long id, String nom, Integer duree, String objectif, String prerequis, String contenue) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.objectif = objectif;
		this.prerequis = prerequis;
		this.contenue = contenue;
	}

	public Matiere(String nom, Integer duree, String objectif, String prerequis, String contenue) {
		super();
		this.nom = nom;
		this.duree = duree;
		this.objectif = objectif;
		this.prerequis = prerequis;
		this.contenue = contenue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

}
