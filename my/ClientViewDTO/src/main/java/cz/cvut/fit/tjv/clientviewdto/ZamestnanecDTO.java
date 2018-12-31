package cz.cvut.fit.tjv.clientviewdto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZamestnanecDTO implements Serializable {

	private Long id;
	private String jmeno;
	private String prijmeni;
	private String adresa;
	private Integer rodneCislo;
	private String prezdivka;
	private Integer pozice_id;
	private Integer prohlidkaId;
	private Collection<KlecDTO> ukliziKlece = new ArrayList<>();

	public ZamestnanecDTO() {
	}

	public ZamestnanecDTO(Long id, String jmeno, String prijmeni, String adresa, Integer rodneCislo, String prezdivka, Integer pozice_id, Integer prohlidkaId, Collection<KlecDTO> ukliziKlece) {
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.adresa = adresa;
		this.rodneCislo = rodneCislo;
		this.prezdivka = prezdivka;
		this.pozice_id = pozice_id;
		this.prohlidkaId = prohlidkaId;
		this.ukliziKlece = ukliziKlece;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Integer getRodneCislo() {
		return rodneCislo;
	}

	public void setRodneCislo(Integer rodneCislo) {
		this.rodneCislo = rodneCislo;
	}

	public String getPrezdivka() {
		return prezdivka;
	}

	public void setPrezdivka(String prezdivka) {
		this.prezdivka = prezdivka;
	}

	public Integer getPozice_id() {
		return pozice_id;
	}

	public void setPozice_id(Integer pozice_id) {
		this.pozice_id = pozice_id;
	}

	public Integer getProhlidkaId() {
		return prohlidkaId;
	}

	public void setProhlidkaId(Integer prohlidkaId) {
		this.prohlidkaId = prohlidkaId;
	}

	public Collection<KlecDTO> getUkliziKlece() {
		return ukliziKlece;
	}

	public void setUkliziKlece(Collection<KlecDTO> ukliziKlece) {
		this.ukliziKlece = ukliziKlece;
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
		final ZamestnanecDTO other = (ZamestnanecDTO) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ZamestnanecDTO{" + "id=" + id + ", jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", adresa=" + adresa + ", rodneCislo=" + rodneCislo + ", prezdivka=" + prezdivka + ", pozice_id=" + pozice_id + ", prohlidkaId=" + prohlidkaId + ", ukliziKlece=" + ukliziKlece + '}';
	}

}
