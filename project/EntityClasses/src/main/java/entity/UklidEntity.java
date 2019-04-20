package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UKLID")
@XmlRootElement
public class UklidEntity implements Serializable {

	@EmbeddedId
	private UklidKey id;

	public UklidEntity() {
	}

	public UklidEntity(UklidKey id) {
		this.id = id;
	}

	public UklidKey getId() {
		return id;
	}

	public void setId(UklidKey id) {
		this.id = id;
	}

	public int getZamestnanecID() {
		return id.getZam_id();
	}

	public int getKlecID() {
		return id.getKlec_id();
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
		final UklidEntity other = (UklidEntity) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UklidEntity{" + "id=" + id + '}';
	}

}
