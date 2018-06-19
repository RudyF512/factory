package factory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("Technicien")
public class Technicien extends RHumaine {

	public Technicien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technicien(Long id, @NotNull String nom, @NotNull String prenom, @NotNull String tel, @NotNull String email,
			Adresse adresse) {
		super(id, nom, prenom, tel, email, adresse);
		// TODO Auto-generated constructor stub
	}
	
	

}
