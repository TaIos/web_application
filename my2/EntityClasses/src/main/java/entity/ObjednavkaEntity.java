package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "OBJEDNAVKA")
@XmlRootElement
public class ObjednavkaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objednavka_gen")
	@SequenceGenerator(name = "objednavka_gen", sequenceName = "OBJEDNAVKA_ID_OBJ_SEQ", allocationSize = 1)
	@Column(name = "ID_OBJ")
	private Integer id;

	@Column(name = "TYP_DOPRAVY")
	private String typDopravy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATUM_VYTVORENI")
	private Date datumVytvoreni;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATUM_DORUCENI")
	private Date datumDoruceni;

	@Column(name = "ID_TUKAN")
	private Integer idTukan;

	@Column(name = "ID_ZAK")
	private Integer idZak;

	public ObjednavkaEntity() {
	}

	public ObjednavkaEntity(Integer id, String typDopravy, Date datumVytvoreni, Date datumDoruceni, Integer idTukan, Integer idZak) {
		this.id = id;
		this.typDopravy = typDopravy;
		this.datumVytvoreni = datumVytvoreni;
		this.datumDoruceni = datumDoruceni;
		this.idTukan = idTukan;
		this.idZak = idZak;
	}

	public Integer getIdZak() {
		return idZak;
	}

	public void setIdZak(Integer idZak) {
		this.idZak = idZak;
	}

	public Integer getIdTukan() {
		return idTukan;
	}

	public void setIdTukan(Integer idTukan) {
		this.idTukan = idTukan;
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
		if (!(object instanceof ObjednavkaEntity)) {
			return false;
		}
		ObjednavkaEntity other = (ObjednavkaEntity) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ObjednavkaEntity{" + "id=" + id + ", typDopravy=" + typDopravy + ", datumVytvoreni=" + datumVytvoreni + ", datumDoruceni=" + datumDoruceni + '}';
	}

}
