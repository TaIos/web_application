package addForms;

import clients.KlecJerseyClient;
import clients.UklidJerseyClient;
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

public class UklidForm extends FormLayout {

	private List<KlecEntity> kleceData;
	private List<ObjednavkaEntity> objednavkyData;
	private List<ZakaznikEntity> zakazniciData;
	private List<ZamestnanecEntity> zamestnanciData;
	private List<UklidEntity> uklidData;

	private TextField cisloZakaznika = new TextField("Cislo zamestnance");
	private TextField cisloKlece = new TextField("Cislo klece");

	private Button save = new Button("pridat");

	private UklidJerseyClient client;
	private MyUI myUI;

	public UklidForm(List<KlecEntity> kleceData, List<ObjednavkaEntity> objednavkyData, List<ZakaznikEntity> zakazniciData, List<ZamestnanecEntity> zamestnanciData, List<UklidEntity> uklidData, UklidJerseyClient client, MyUI myUI) {
		this.kleceData = kleceData;
		this.objednavkyData = objednavkyData;
		this.zakazniciData = zakazniciData;
		this.zamestnanciData = zamestnanciData;
		this.uklidData = uklidData;
		this.client = client;
		this.myUI = myUI;
		addComponents(cisloZakaznika, cisloKlece, save);
		setSizeUndefined();
	}
}
