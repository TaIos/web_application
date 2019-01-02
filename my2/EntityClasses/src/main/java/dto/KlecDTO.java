package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entity.KlecEntity;

public class KlecDTO implements Serializable {

	public KlecDTO() {
	}

	private List<KlecEntity> klece = new ArrayList<>();

	public List<KlecEntity> getKlece() {
		return klece;
	}

	public void setKlece(List<KlecEntity> klece) {
		this.klece = klece;
	}

}
