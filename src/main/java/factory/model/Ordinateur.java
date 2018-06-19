package factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Ordinateur extends RMaterielle {
	
	public Ordinateur() {
		super();
	}

	public Ordinateur(Long id, String code, Long cout, Boolean dispo) {
		super(id, code, cout, dispo);
	}

	public Ordinateur(Long id, String code, Long cout, Boolean dispo, String brand, String proc, Integer ram,
			Integer qdd, String anneeAchat) {
		super(id, code, cout, dispo);
		this.brand = brand;
		this.proc = proc;
		this.ram = ram;
		this.qdd = qdd;
		this.anneeAchat = anneeAchat;
	}
	
	

	@Column(name = "brand")
    private String brand;

    @Column(name = "jhi_proc")
    private String proc;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "qdd")
    private Integer qdd;

    @Column(name = "annee_achat")
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
