package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entity.ZamestnanecEntity;

public class ZamestnanecDTO implements Serializable {

	private List<ZamestnanecEntity> zamestnanci = new ArrayList<>();

	public List<ZamestnanecEntity> getZamestnanci() {
		return zamestnanci;
	}

	public void setZamestnanci(List<ZamestnanecEntity> zamestnanci) {
		this.zamestnanci = zamestnanci;
	}

}
