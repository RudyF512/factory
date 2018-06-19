package factory.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends RHumaine {

	private static final long serialVersionUID = 1L;


  @NotNull
  @Column(name = "expertise", nullable = false)
  private Integer expertise;

  @Enumerated(EnumType.STRING)
  @Column(name = "lvl_stagiaire")
  private LvlStagiaire lvlStagiaire;

  @OneToMany(mappedBy = "formateur")
  @JsonIgnore
  private Set<Formation> formations = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "formateur_matieres",
             joinColumns = @JoinColumn(name="formateurs_id", referencedColumnName="id"),
             inverseJoinColumns = @JoinColumn(name="matieres_id", referencedColumnName="id"))
  private Set<Matiere> matieres = new HashSet<>();

  // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove



  public Formateur() {
		super();
	}

	public Formateur(@NotNull Integer expertise, LvlStagiaire lvlStagiaire, Set<Formation> formations,
			Set<Matiere> matieres) {
		super();
		this.expertise = expertise;
		this.lvlStagiaire = lvlStagiaire;
		this.formations = formations;
		this.matieres = matieres;
	}

	public Formateur(Long id, @NotNull String nom, @NotNull String prenom, @NotNull String tel, @NotNull String email,
			Adresse adresse,@NotNull Integer expertise, LvlStagiaire lvlStagiaire, Set<Formation> formations,
			Set<Matiere> matieres) {
		super(id, nom, prenom, tel, email, adresse);
		
		this.expertise = expertise;
		this.lvlStagiaire = lvlStagiaire;
		this.formations = formations;
		this.matieres = matieres;
	}

	public Integer getExpertise() {
		return expertise;
	}

	public void setExpertise(Integer expertise) {
		this.expertise = expertise;
	}

	public LvlStagiaire getLvlStagiaire() {
		return lvlStagiaire;
	}

	public void setLvlStagiaire(LvlStagiaire lvlStagiaire) {
		this.lvlStagiaire = lvlStagiaire;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
