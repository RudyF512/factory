package factory.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Column(name = "nom", nullable = false)
	@JsonView(Views.ViewCommon.class)
	private String nom;

	@Column(name = "date_debut", nullable = false)
	@JsonView(Views.ViewCommon.class)
	private Date dateDebut;

	@Column(name = "date_fin", nullable = false)
	@JsonView(Views.ViewCommon.class)
	private Date dateFin;

	@OneToMany(mappedBy = "formation")
	@JsonView(Views.ViewCommon.class)
	private Set<Stagiaire> stagiaires = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "formation_modules", joinColumns = @JoinColumn(name = "formations_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "modules_id", referencedColumnName = "id"))
	@JsonView(Views.ViewFormation.class)
	private Set<Module> modules = new HashSet<>();

	@ManyToOne
	@JsonView(Views.ViewCommon.class)
	private Formateur formateur;

	public Formation() {
		super();
	}

	public Formation(Long id, @NotNull String nom, @NotNull Date dateDebut, @NotNull Date dateFin,
			 Set<Module> modules, Formateur formateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.modules = modules;
		this.formateur = formateur;
	}

	public Formation(@NotNull String nom, @NotNull Date dateDebut, @NotNull Date dateFin,
			Set<Module> modules, Formateur formateur) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.modules = modules;
		this.formateur = formateur;
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

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	
	public void addStagiaires(Stagiaire stagiaires) {
		this.stagiaires.add(stagiaires);
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
