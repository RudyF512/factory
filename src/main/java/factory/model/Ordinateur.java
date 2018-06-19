package factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
public class Ordinateur extends RMaterielle {
	
	@NotNull
    @Column(name = "brand", nullable = false)
    private String brand;

    @NotNull
    @Column(name = "jhi_proc", nullable = false)
    private String proc;

    @NotNull
    @Column(name = "ram", nullable = false)
    private Integer ram;

    @NotNull
    @Column(name = "qdd", nullable = false)
    private Integer qdd;

    @NotNull
    @Column(name = "annee_achat", nullable = false)
    private String anneeAchat;

	public Ordinateur(@NotNull String brand, @NotNull String proc, @NotNull Integer ram, @NotNull Integer qdd,
			@NotNull String anneeAchat) {
		super();
		this.brand = brand;
		this.proc = proc;
		this.ram = ram;
		this.qdd = qdd;
		this.anneeAchat = anneeAchat;
	}

	public Ordinateur() {
		super();
	}

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
