package factory.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class RMaterielle {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "cout", nullable = false)
    private Long cout;

    @Column(name = "dispo")
    private Boolean dispo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public RMaterielle code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCout() {
        return cout;
    }

    public RMaterielle cout(Long cout) {
        this.cout = cout;
        return this;
    }

    public void setCout(Long cout) {
        this.cout = cout;
    }

    public Boolean isDispo() {
        return dispo;
    }

    public RMaterielle dispo(Boolean dispo) {
        this.dispo = dispo;
        return this;
    }

    public void setDispo(Boolean dispo) {
        this.dispo = dispo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RMaterielle rMaterielle = (RMaterielle) o;
        if (rMaterielle.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rMaterielle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RMaterielle{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", cout=" + getCout() +
            ", dispo='" + isDispo() + "'" +
            "}";
    }
	
	
}