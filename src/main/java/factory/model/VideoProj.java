package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("VideoProj")
public class VideoProj extends RMaterielle {

	@Column(name = "brand")
	@JsonView(Views.ViewRMaterielle.class)
	private String brand;

	@Column(name = "resolution")
	@JsonView(Views.ViewRMaterielle.class)
	private Integer resolution;

	@Column(name = "hdmi")
	@JsonView(Views.ViewRMaterielle.class)
	private Boolean hdmi;

	@Column(name = "vga")
	@JsonView(Views.ViewRMaterielle.class)
	private Boolean vga;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getResolution() {
		return resolution;
	}

	public void setResolution(Integer resolution) {
		this.resolution = resolution;
	}

	public Boolean getHdmi() {
		return hdmi;
	}

	public void setHdmi(Boolean hdmi) {
		this.hdmi = hdmi;
	}

	public Boolean getVga() {
		return vga;
	}

	public void setVga(Boolean vga) {
		this.vga = vga;
	}

	public VideoProj(Long id, String code, Long cout, Boolean dispo) {
		super(id, code, cout, dispo);
	}

	public VideoProj() {
		super();
	}

	public VideoProj(Long id, String code, Long cout, Boolean dispo, String brand, Integer resolution, Boolean hdmi,
			Boolean vga) {
		super(id, code, cout, dispo);
		this.brand = brand;
		this.resolution = resolution;
		this.hdmi = hdmi;
		this.vga = vga;
	}

}
