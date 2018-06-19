package factory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends RHumaine {
	
    @OneToOne
    @JoinColumn(unique = true)
    private Ordinateur ordinateur;

    @ManyToOne
    private Formation formation;

	public Stagiaire() {
		super();
	}

	public Stagiaire(Long id, @NotNull String nom, @NotNull String prenom, @NotNull String tel, @NotNull String email,
			Adresse adresse, Ordinateur ordinateur, Formation formation) {
		super(id, nom, prenom, tel, email, adresse);
		this.ordinateur = ordinateur;
		this.formation = formation;
	}

	public Stagiaire(Ordinateur ordinateur, Formation formation) {
		super();
		this.ordinateur = ordinateur;
		this.formation = formation;
	}

	public Stagiaire(@NotNull String nom, @NotNull String prenom, @NotNull String tel, @NotNull String email,
			Adresse adresse, Ordinateur ordinateur, Formation formation) {
		super(nom, prenom, tel, email, adresse);
		this.ordinateur = ordinateur;
		this.formation = formation;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
    

}
