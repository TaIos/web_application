package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entity.ZakaznikEntity;

public class ZakaznikDTO implements Serializable {

	public ZakaznikDTO() {
	}

	public ZakaznikDTO(List<ZakaznikEntity> zakaznici) {
		this.zakaznici = zakaznici;
	}

	private List<ZakaznikEntity> zakaznici = new ArrayList<>();

	public List<ZakaznikEntity> getZakaznici() {
		return zakaznici;
	}

	public void setZakaznici(List<ZakaznikEntity> zakaznici) {
		this.zakaznici = zakaznici;
	}

}
