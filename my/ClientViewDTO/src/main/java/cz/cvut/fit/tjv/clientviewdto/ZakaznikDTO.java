package cz.cvut.fit.tjv.clientviewdto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZakaznikDTO implements Serializable {

	private Long id;
	private String jmeno;
	private String prijmeni;
	private String dorucovaciAdresa;
	private String email;
	private Collection<ObjednavkaDTO> objednavky = new ArrayList<>();

	public ZakaznikDTO() {
	}

	public ZakaznikDTO(Long id, String jmeno, String prijmeni, String dorucovaciAdresa, String email, Collection<ObjednavkaDTO> objednavky) {
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.dorucovaciAdresa = dorucovaciAdresa;
		this.email = email;
		this.objednavky = objednavky;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<ObjednavkaDTO> getObjednavky() {
		return objednavky;
	}

	public void setObjednavky(Collection<ObjednavkaDTO> objednavky) {
		this.objednavky = objednavky;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.id);
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
		final ZakaznikDTO other = (ZakaznikDTO) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ZakaznikDTO{" + "id=" + id + ", jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", dorucovaciAdresa=" + dorucovaciAdresa + ", email=" + email + ", objednavky=" + objednavky + '}';
	}

}
