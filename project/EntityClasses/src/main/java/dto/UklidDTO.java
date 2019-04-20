package dto;

import entity.UklidEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UklidDTO implements Serializable {

	public UklidDTO() {
	}

	public UklidDTO(List<UklidEntity> uklid) {
		this.uklid = uklid;
	}

	private List<UklidEntity> uklid = new ArrayList<>();

	public List<UklidEntity> getUklid() {
		return uklid;
	}

	public void setUklid(List<UklidEntity> uklid) {
		this.uklid = uklid;
	}

}
