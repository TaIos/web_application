package forms;

import clients.KlecJerseyClient;
import clients.ZamestnanecJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import entity.KlecEntity;
import entity.ObjednavkaEntity;
import entity.UklidEntity;
import entity.ZakaznikEntity;
import entity.ZamestnanecEntity;
import java.util.List;
import ui.MyUI;

public class ZamestnanecForm extends FormLayout {

	private List<KlecEntity> kleceData;
	private List<ObjednavkaEntity> objednavkyData;
	private List<ZakaznikEntity> zakazniciData;
	private List<ZamestnanecEntity> zamestnanciData;
	private List<UklidEntity> uklidData;

	private TextField jmeno = new TextField("Jmeno");
	private TextField prijmeni = new TextField("Prijmeni");
	private TextField adresa = new TextField("Adresa");
	private TextField rodneCislo = new TextField("Rodne cislo");
	private TextField cisloPozice = new TextField("Cislo pozice");
	private TextField email = new TextField("Email");

	private Button save = new Button("pridat");

	private ZamestnanecJerseyClient client;
	private MyUI myUI;

	public ZamestnanecForm(List<KlecEntity> kleceData, List<ObjednavkaEntity> objednavkyData, List<ZakaznikEntity> zakazniciData, List<ZamestnanecEntity> zamestnanciData, List<UklidEntity> uklidData, ZamestnanecJerseyClient client, MyUI myUI) {
		this.kleceData = kleceData;
		this.objednavkyData = objednavkyData;
		this.zakazniciData = zakazniciData;
		this.zamestnanciData = zamestnanciData;
		this.uklidData = uklidData;
		this.client = client;
		this.myUI = myUI;
		addComponents(jmeno, prijmeni, adresa, rodneCislo, cisloPozice, email, save);
		setSizeUndefined();
	}

}
