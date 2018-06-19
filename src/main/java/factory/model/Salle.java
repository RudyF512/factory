package factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Salle extends RMaterielle {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Column(name = "nom_salle", nullable = false)
    private String nomSalle;

    @NotNull
    @Column(name = "capacite", nullable = false)
    private Integer capacite;

	public Salle() {
		super();
	}

	public Salle(Long id, @NotNull String nomSalle, @NotNull Integer capacite) {
		super();
		this.id = id;
		this.nomSalle = nomSalle;
		this.capacite = capacite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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


    
    

}
