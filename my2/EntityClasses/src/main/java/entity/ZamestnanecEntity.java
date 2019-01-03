package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ZAMESTNANEC")
@XmlRootElement
public class ZamestnanecEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zamestnanec_gen")
	@SequenceGenerator(name = "zamestnanec_gen", sequenceName = "ZAKAZNIK_ID_ZAK_SEQ", allocationSize = 1)
	@Column(name = "ZAM_ID")
	private Integer id;

	@Column(name = "JMENO")
	private String jmeno;

	@Column(name = "PRIJMENI")
	private String prijmeni;

	@Column(name = "ADRESA")
	private String adresa;

	@Column(name = "RODNE_CISLO")
	private Integer rodneCislo;

	@Column(name = "PREZDIVKA")
	private String prezdivka;

	@Column(name = "POZICE_ID")
	private Integer pozice_id;

	@Column(name = "PROHLIDKA_ID")
	private Integer prohlidkaId;

	@ManyToMany
	@JoinTable(
		name = "UKLID",
		joinColumns = @JoinColumn(name = "ZAM_ID", referencedColumnName = "ZAM_ID"),
		inverseJoinColumns = @JoinColumn(name = "KLEC_ID", referencedColumnName = "KLEC_ID")
	)
	private Collection<KlecEntity> ukliziKlece = new ArrayList<KlecEntity>();

	public ZamestnanecEntity() {
	}

	public ZamestnanecEntity(Integer id, String jmeno, String prijmeni, String adresa, Integer rodneCislo, String prezdivka, Integer pozice_id, Integer prohlidkaId, Collection<KlecEntity> ukliziKlece) {
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

	public ZamestnanecEntity(Integer id, String jmeno, String prijmeni, String adresa, Integer rodneCislo, String prezdivka, Integer pozice_id, Integer prohlidkaId) {
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.adresa = adresa;
		this.rodneCislo = rodneCislo;
		this.prezdivka = prezdivka;
		this.pozice_id = pozice_id;
		this.prohlidkaId = prohlidkaId;
	}

	@JsonbTransient
	@XmlTransient
	public Collection<KlecEntity> getUkliziKlece() {
		return ukliziKlece;
	}

	public void setRodneCislo(Integer rodneCislo) {
		this.rodneCislo = rodneCislo;
	}

	public void setUkliziKlece(Collection<KlecEntity> ukliziKlece) {
		this.ukliziKlece = ukliziKlece;
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

	public void setRodneCoslo(Integer rodneCoslo) {
		this.rodneCislo = rodneCoslo;
	}

	public String getPrezdivka() {
		return prezdivka;
	}

	public void setPrezdivka(String prezdivka) {
		this.prezdivka = prezdivka;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ZamestnanecEntity)) {
			return false;
		}
		ZamestnanecEntity other = (ZamestnanecEntity) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ZamestnanecEntity{" + "id=" + id + ", jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", adresa=" + adresa + ", rodneCoslo=" + rodneCislo + ", prezdivka=" + prezdivka + '}';
	}

}
