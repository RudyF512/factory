package factory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Technicien")
public class Technicien extends RHumaine {

	public Technicien() {
		super();
	}

	public Technicien(Long id, String nom, String prenom, String tel, String email, Adresse adresse) {
		super(id, nom, prenom, tel, email, adresse);
	}

	public Technicien(String nom, String prenom, String tel, String email, Adresse adresse) {
		super(nom, prenom, tel, email, adresse);
	}

}
