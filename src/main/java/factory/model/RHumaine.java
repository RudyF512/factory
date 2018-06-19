package factory.model;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "rhumaine")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
public class RHumaine {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nom", nullable = false)
	private String nom;

	@NotNull
	@Column(name = "prenom", nullable = false)
	private String prenom;

	@NotNull
	@Column(name = "tel", nullable = false)
	private String tel;

	@NotNull
	@Column(name = "email", nullable = false)
	private String email;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "st_street", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "st_zipcode", length = 10)),
			@AttributeOverride(name = "ville", column = @Column(name = "st_city", length = 100)) })
	@JsonView(Views.ViewCommon.class)
	private Adresse adresse;

	public RHumaine() {
		super();
	}

	public RHumaine(Long id, @NotNull String nom, @NotNull String prenom, @NotNull String tel, @NotNull String email,
			Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
		RHumaine rHumain = (RHumaine) o;
		if (rHumain.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), rHumain.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "RHumain{" + "id=" + getId() + ", nom='" + getNom() + "'" + ", prenom='" + getPrenom() + "'" + ", tel='"
				+ getTel() + "'" + ", email='" + getEmail() + "'" + "}";
	}

}
