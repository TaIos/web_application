package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "KLEC")
@XmlRootElement
public class KlecEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klec_gen")
	@SequenceGenerator(name = "klec_gen", sequenceName = "KLEC_KLEC_ID_SEQ", allocationSize = 1)
	@Column(name = "KLEC_ID")
	private Integer id;

	@Column(name = "POCET_TUKANU")
	private Integer pocetTukanu;

	@Column(name = "VELIKOST_KLECE_M3")
	private Float velikostKleceM3;

	@Column(name = "VYBAVENI")
	private String vybaveni;

	@Column(name = "PROHLIDKA_ID")
	private Integer prohlidkaId;

	@ManyToMany(mappedBy = "ukliziKlece")
	private Collection<ZamestnanecEntity> jeUklizena = new ArrayList<>();

	public KlecEntity() {
	}

	public KlecEntity(Integer id, Integer pocetTukanu, Float velikostKleceM3, String vybaveni, Integer prohlidkaId, Collection<ZamestnanecEntity> jeUklizena) {
		this.id = id;
		this.pocetTukanu = pocetTukanu;
		this.velikostKleceM3 = velikostKleceM3;
		this.vybaveni = vybaveni;
		this.prohlidkaId = prohlidkaId;
		this.jeUklizena = jeUklizena;
	}

	public KlecEntity(Integer id, Integer pocetTukanu, Float velikostKleceM3, String vybaveni, Integer prohlidkaId) {
		this.id = id;
		this.pocetTukanu = pocetTukanu;
		this.velikostKleceM3 = velikostKleceM3;
		this.vybaveni = vybaveni;
		this.prohlidkaId = prohlidkaId;
	}

	@XmlTransient
	@JsonbTransient
	public Collection<ZamestnanecEntity> getJeUklizena() {
		return jeUklizena;
	}

	public void setJeUklizena(Collection<ZamestnanecEntity> jeUklizena) {
		this.jeUklizena = jeUklizena;
	}

	public Integer getProhlidkaId() {
		return prohlidkaId;
	}

	public void setProhlidkaId(Integer prohlidkaId) {
		this.prohlidkaId = prohlidkaId;
	}

	public Integer getPocetTukanu() {
		return pocetTukanu;
	}

	public void setPocetTukanu(Integer pocetTukanu) {
		this.pocetTukanu = pocetTukanu;
	}

	public Float getVelikostKleceM3() {
		return velikostKleceM3;
	}

	public void setVelikostKleceM3(Float velikostKleceM3) {
		this.velikostKleceM3 = velikostKleceM3;
	}

	public String getVybaveni() {
		return vybaveni;
	}

	public void setVybaveni(String vybaveni) {
		this.vybaveni = vybaveni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 3;
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
		final KlecEntity other = (KlecEntity) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "KlecEntity{" + "id=" + id + ", pocetTukanu=" + pocetTukanu + ", velikostKleceM3=" + velikostKleceM3 + ", vybaveni=" + vybaveni + '}';
	}

}
