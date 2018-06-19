package factory.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class VideoProj extends RMaterielle {

		
	    @NotNull
	    @Column(name = "brand", nullable = false)
	    private String brand;

	    @NotNull
	    @Column(name = "resolution", nullable = false)
	    private Integer resolution;

	    @Column(name = "hdmi")
	    private Boolean hdmi;

	    @Column(name = "vga")
	    private Boolean vga;

	    



		public VideoProj() {
			super();
			// TODO Auto-generated constructor stub
		}

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

		@Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        VideoProj videoProj = (VideoProj) o;
	        if (videoProj.getId() == null || getId() == null) {
	            return false;
	        }
	        return Objects.equals(getId(), videoProj.getId());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }

	    @Override
	    public String toString() {
	        return "VideoProj{" +
	            "id=" + getId() +
	            ", brand='" + getBrand() + "'" +
	            ", resolution=" + getResolution() +
	            ", hdmi='" + getHdmi() + "'" +
	            ", vga='" + getVga() + "'" +
	            "}";
	    }
	
}
