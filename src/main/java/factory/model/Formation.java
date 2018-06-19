package factory.model;

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



@Entity
public class Formation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "date_debut", nullable = false)
    private String dateDebut;

    @NotNull
    @Column(name = "date_fin", nullable = false)
    private String dateFin;

    @OneToMany(mappedBy = "formation")
    private Set<Stagiaire> stagiaires = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "formation_modules",
               joinColumns = @JoinColumn(name="formations_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="modules_id", referencedColumnName="id"))
    private Set<Module> modules = new HashSet<>();

    @ManyToOne
    private Formateur formateur;

	public Formation() {
		super();
	}

	public Formation(Long id, @NotNull String nom, @NotNull String dateDebut, @NotNull String dateFin,
			Set<Stagiaire> stagiaires, Set<Module> modules, Formateur formateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.stagiaires = stagiaires;
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

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
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
