package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "rmaterielle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true )
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
public class RMaterielle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Column(name = "code", nullable = false)
	@JsonView(Views.ViewCommon.class)
	private String code;

	@Column(name = "cout", nullable = false)
	@JsonView(Views.ViewCommon.class)
	private Long cout;

	@Column(name = "dispo", nullable = false)
	@JsonView(Views.ViewCommon.class)
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

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCout() {
		return cout;
	}

	public void setCout(Long cout) {
		this.cout = cout;
	}

	public Boolean getDispo() {
		return dispo;
	}

	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}

	public RMaterielle(Long id, String code, Long cout, Boolean dispo) {
		super();
		this.id = id;
		this.code = code;
		this.cout = cout;
		this.dispo = dispo;
	}

	public RMaterielle() {
		super();
	}

	public RMaterielle(String code, Long cout, Boolean dispo) {
		super();
		this.code = code;
		this.cout = cout;
		this.dispo = dispo;
	}

}
