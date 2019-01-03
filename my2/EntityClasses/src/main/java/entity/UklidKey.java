package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UklidKey implements Serializable {

	@Column(name = "ZAM_ID")
	private Integer zam_id;

	@Column(name = "KLEC_ID")
	private Integer klec_id;

	public UklidKey() {
	}

	public UklidKey(Integer zam_id, Integer klec_id) {
		this.zam_id = zam_id;
		this.klec_id = klec_id;
	}

	public Integer getZam_id() {
		return zam_id;
	}

	public void setZam_id(Integer zam_id) {
		this.zam_id = zam_id;
	}

	public Integer getKlec_id() {
		return klec_id;
	}

	public void setKlec_id(Integer klec_id) {
		this.klec_id = klec_id;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 43 * hash + Objects.hashCode(this.zam_id);
		hash = 43 * hash + Objects.hashCode(this.klec_id);
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
		final UklidKey other = (UklidKey) obj;
		if (!Objects.equals(this.zam_id, other.zam_id)) {
			return false;
		}
		if (!Objects.equals(this.klec_id, other.klec_id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UklidKey{" + "zam_id=" + zam_id + ", klec_id=" + klec_id + '}';
	}

}
