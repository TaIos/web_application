package cz.cvut.fit.tjv.clientviewdto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class KlecDTO implements Serializable {

	private Long id;
	private Integer pocetTukanu;
	private Double velikostKleceM3;
	private String vybaveni;
	private Integer prohlidkaId;
	private ArrayList<ZamestnanecDTO> jeUklizena = new ArrayList<>();

	public KlecDTO() {
	}

	public KlecDTO(Long id, Integer pocetTukanu, Double velikostKleceM3, String vybaveni, Integer prohlidkaId, ArrayList<ZamestnanecDTO> jeUklizena) {
		this.id = id;
		this.pocetTukanu = pocetTukanu;
		this.velikostKleceM3 = velikostKleceM3;
		this.vybaveni = vybaveni;
		this.prohlidkaId = prohlidkaId;
		this.jeUklizena = jeUklizena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPocetTukanu() {
		return pocetTukanu;
	}

	public void setPocetTukanu(Integer pocetTukanu) {
		this.pocetTukanu = pocetTukanu;
	}

	public Double getVelikostKleceM3() {
		return velikostKleceM3;
	}

	public void setVelikostKleceM3(Double velikostKleceM3) {
		this.velikostKleceM3 = velikostKleceM3;
	}

	public String getVybaveni() {
		return vybaveni;
	}

	public void setVybaveni(String vybaveni) {
		this.vybaveni = vybaveni;
	}

	public Integer getProhlidkaId() {
		return prohlidkaId;
	}

	public void setProhlidkaId(Integer prohlidkaId) {
		this.prohlidkaId = prohlidkaId;
	}

	public ArrayList<ZamestnanecDTO> getJeUklizena() {
		return jeUklizena;
	}

	public void setJeUklizena(ArrayList<ZamestnanecDTO> jeUklizena) {
		this.jeUklizena = jeUklizena;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 19 * hash + Objects.hashCode(this.id);
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
		final KlecDTO other = (KlecDTO) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "KlecDTO{" + "id=" + id + ", pocetTukanu=" + pocetTukanu + ", velikostKleceM3=" + velikostKleceM3 + ", vybaveni=" + vybaveni + ", prohlidkaId=" + prohlidkaId + ", jeUklizena=" + jeUklizena + '}';
	}

}
