package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entity.ObjednavkaEntity;

public class ObjednavkaDTO implements Serializable {

	public ObjednavkaDTO() {
	}

	public ObjednavkaDTO(List<ObjednavkaEntity> objednavky) {
		this.objednavky = objednavky;
	}

	private List<ObjednavkaEntity> objednavky = new ArrayList<>();

	public List<ObjednavkaEntity> getObjednavky() {
		return objednavky;
	}

	public void setObjednavky(List<ObjednavkaEntity> objednavky) {
		this.objednavky = objednavky;
	}

}
