package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ZAKAZNIK")
@XmlRootElement
public class ZakaznikEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zakaznik_gen")
	@SequenceGenerator(name = "zakaznik_gen", sequenceName = "ZAKAZNIK_ID_ZAK_SEQ", allocationSize = 1)
	@Column(name = "ID_ZAK")
	private Long id;

	@Column(name = "JMENO")
	private String jmeno;

	@Column(name = "PRIJMENI")
	private String prijmeni;

	@Column(name = "DORUCOVACI_ADRESA")
	private String dorucovaciAdresa;

	@Column(name = "EMAIL")
	private String email;

	@OneToMany
	@JoinColumn(name = "ID_ZAK")
	private Collection<ObjednavkaEntity> objednavky = new ArrayList<>();

	public ZakaznikEntity() {
	}

	public ZakaznikEntity(Long id, String jmeno, String prijmeni, String dorucovaciAdresa, String email) {
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.dorucovaciAdresa = dorucovaciAdresa;
		this.email = email;
	}

	public void setObjednavky(Collection<ObjednavkaEntity> objednavky) {
		this.objednavky = objednavky;
	}

	@XmlTransient
	public Collection<ObjednavkaEntity> getObjednavky() {
		return objednavky;
	}

	public Long getId() {
		return id;
	}

	public String getJmeno() {
		return jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public String getPrijmeni() {
		return prijmeni;
	}

	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}

	public String getDorucovaciAdresa() {
		return dorucovaciAdresa;
	}

	public void setDorucovaciAdresa(String dorucovaciAdresa) {
		this.dorucovaciAdresa = dorucovaciAdresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ZakaznikEntity other = (ZakaznikEntity) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ZakaznikEntity{" + "id=" + id + ", jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", dorucovaciAdresa=" + dorucovaciAdresa + ", email=" + email + '}';
	}

}
