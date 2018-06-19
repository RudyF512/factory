package factory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("Gestionnaire")
public class Gestionnaire extends RHumaine {

	public Gestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire(Long id, @NotNull String nom, @NotNull String prenom, @NotNull String tel,
			@NotNull String email, Adresse adresse) {
		super(id, nom, prenom, tel, email, adresse);
		// TODO Auto-generated constructor stub
	}

	
	
}
