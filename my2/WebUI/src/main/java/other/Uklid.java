package other;

import entity.KlecEntity;
import entity.ZamestnanecEntity;
import java.util.Objects;

public class Uklid {

	private ZamestnanecEntity zamestnanec;
	private KlecEntity klec;

	public Uklid() {
	}

	public Uklid(ZamestnanecEntity zamestnanec, KlecEntity klec) {
		this.zamestnanec = zamestnanec;
		this.klec = klec;
	}

	public String getZamestnanecName() {
		return zamestnanec.getJmeno() + " " + zamestnanec.getPrijmeni();
	}

	public Integer getZamestnanecId() {
		return zamestnanec.getId();
	}

	public Integer getKlecId() {
		return klec.getId();
	}

	public void setZamestnanec(ZamestnanecEntity zamestnanec) {
		this.zamestnanec = zamestnanec;
	}

	public void setKlec(KlecEntity klec) {
		this.klec = klec;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + Objects.hashCode(this.zamestnanec);
		hash = 17 * hash + Objects.hashCode(this.klec);
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
		final Uklid other = (Uklid) obj;
		if (!Objects.equals(this.zamestnanec, other.zamestnanec)) {
			return false;
		}
		if (!Objects.equals(this.klec, other.klec)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Uklid{" + "zamestnanec=" + zamestnanec + ", klec=" + klec + '}';
	}

}
