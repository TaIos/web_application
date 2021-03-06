package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entity.ZamestnanecEntity;

public class ZamestnanecDTO implements Serializable {

	public ZamestnanecDTO() {
	}

	public ZamestnanecDTO(List<ZamestnanecEntity> zamestnanci) {
		this.zamestnanci = zamestnanci;
	}

	private List<ZamestnanecEntity> zamestnanci = new ArrayList<>();

	public List<ZamestnanecEntity> getZamestnanci() {
		return zamestnanci;
	}

	public void setZamestnanci(List<ZamestnanecEntity> zamestnanci) {
		this.zamestnanci = zamestnanci;
	}

}
