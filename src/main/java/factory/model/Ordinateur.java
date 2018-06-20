package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Ordinateur")
public class Ordinateur extends RMaterielle {

	public Ordinateur() {
		super();
	}

	public Ordinateur(String code, Long cout, Boolean dispo) {
		super(code, cout, dispo);
	}

	public Ordinateur(String code, Long cout, Boolean dispo, String brand, String proc, Integer ram,
			Integer qdd, String anneeAchat) {
		super(code, cout, dispo);
		this.brand = brand;
		this.proc = proc;
		this.ram = ram;
		this.qdd = qdd;
		this.anneeAchat = anneeAchat;
	}

	@Column(name = "brand")
	@JsonView(Views.ViewRMaterielle.class)
	private String brand;

	@Column(name = "jhi_proc")
	@JsonView(Views.ViewRMaterielle.class)
	private String proc;

	@Column(name = "ram")
	@JsonView(Views.ViewRMaterielle.class)
	private Integer ram;

	@Column(name = "qdd")
	@JsonView(Views.ViewRMaterielle.class)
	private Integer qdd;

	@Column(name = "annee_achat")
	@JsonView(Views.ViewRMaterielle.class)
	private String anneeAchat;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProc() {
		return proc;
	}

	public void setProc(String proc) {
		this.proc = proc;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getQdd() {
		return qdd;
	}

	public void setQdd(Integer qdd) {
		this.qdd = qdd;
	}

	public String getAnneeAchat() {
		return anneeAchat;
	}

	public void setAnneeAchat(String anneeAchat) {
		this.anneeAchat = anneeAchat;
	}

}
