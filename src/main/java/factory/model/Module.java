package factory.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Module {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewRHumaine.class)
	private Long id;

	@NotNull
	@Column(name = "date_debut", nullable = false)
	@JsonView(Views.ViewRHumaine.class)
	private Date dateDebut;

	@NotNull
	@Column(name = "date_fin", nullable = false)
	@JsonView(Views.ViewRHumaine.class)
	private Date dateFin;

	@OneToOne
	@JoinColumn(unique = true)
	@JsonView(Views.ViewRHumaine.class)
	private Salle salle;

	@OneToOne
	@JoinColumn(unique = true)
	@JsonView(Views.ViewRHumaine.class)
	private Matiere matiere;

	@OneToOne
	@JoinColumn(unique = true)
	@JsonView(Views.ViewRHumaine.class)
	private Formateur formateur;

	@ManyToMany(mappedBy = "modules")
	@JsonView(Views.ViewRHumaine.class)
	private Set<Formation> formations = new HashSet<>();

	public Module() {
		super();
	}

	public Module(Long id, @NotNull Date dateDebut, @NotNull Date dateFin, Salle salle, Matiere matiere,
			Formateur formateur, Set<Formation> formations) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.salle = salle;
		this.matiere = matiere;
		this.formateur = formateur;
		this.formations = formations;
	}

	public Module(@NotNull Date dateDebut, @NotNull Date dateFin, Salle salle, Matiere matiere, Formateur formateur,
			Set<Formation> formations) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.salle = salle;
		this.matiere = matiere;
		this.formateur = formateur;
		this.formations = formations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Module module = (Module) o;
		if (module.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), module.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
