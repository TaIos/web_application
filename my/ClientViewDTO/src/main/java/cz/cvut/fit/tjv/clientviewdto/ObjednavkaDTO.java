package cz.cvut.fit.tjv.clientviewdto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ObjednavkaDTO implements Serializable {

	private Long id;
	private String typDopravy;
	private Date datumVytvoreni;
	private Date datumDoruceni;
	private Integer idTukan;
	private Integer idZak;

	public ObjednavkaDTO() {
	}

	public ObjednavkaDTO(Long id, String typDopravy, Date datumVytvoreni, Date datumDoruceni, Integer idTukan, Integer idZak) {
		this.id = id;
		this.typDopravy = typDopravy;
		this.datumVytvoreni = datumVytvoreni;
		this.datumDoruceni = datumDoruceni;
		this.idTukan = idTukan;
		this.idZak = idZak;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypDopravy() {
		return typDopravy;
	}

	public void setTypDopravy(String typDopravy) {
		this.typDopravy = typDopravy;
	}

	public Date getDatumVytvoreni() {
		return datumVytvoreni;
	}

	public void setDatumVytvoreni(Date datumVytvoreni) {
		this.datumVytvoreni = datumVytvoreni;
	}

	public Date getDatumDoruceni() {
		return datumDoruceni;
	}

	public void setDatumDoruceni(Date datumDoruceni) {
		this.datumDoruceni = datumDoruceni;
	}

	public Integer getIdTukan() {
		return idTukan;
	}

	public void setIdTukan(Integer idTukan) {
		this.idTukan = idTukan;
	}

	public Integer getIdZak() {
		return idZak;
	}

	public void setIdZak(Integer idZak) {
		this.idZak = idZak;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.id);
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
		final ObjednavkaDTO other = (ObjednavkaDTO) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ObjednavkaDTO{" + "id=" + id + ", typDopravy=" + typDopravy + ", datumVytvoreni=" + datumVytvoreni + ", datumDoruceni=" + datumDoruceni + ", idTukan=" + idTukan + ", idZak=" + idZak + '}';
	}

}
