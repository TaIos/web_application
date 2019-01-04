package addForms;

import clients.KlecJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import dto.KlecDTO;
import entity.KlecEntity;
import entity.ObjednavkaEntity;
import entity.UklidEntity;
import entity.ZakaznikEntity;
import entity.ZamestnanecEntity;
import java.util.List;
import ui.MyUI;

public class KlecForm extends FormLayout {

	private List<KlecEntity> kleceData;
	private List<ObjednavkaEntity> objednavkyData;
	private List<ZakaznikEntity> zakazniciData;
	private List<ZamestnanecEntity> zamestnanciData;
	private List<UklidEntity> uklidData;

	private TextField pocetTukanuField = new TextField("Pocet tukanu");
	private TextField velikostField = new TextField("Velikost v m3");
	private TextField vybaveniField = new TextField("Vybaveni");

	private KlecJerseyClient client;
	private MyUI myUI;

	private Button save = new Button("pridat", e -> {
		add();
	});

	public KlecForm(List<KlecEntity> kleceData, List<ObjednavkaEntity> objednavkyData, List<ZakaznikEntity> zakazniciData, List<ZamestnanecEntity> zamestnanciData, List<UklidEntity> uklidData, KlecJerseyClient client, MyUI myUI) {
		this.kleceData = kleceData;
		this.objednavkyData = objednavkyData;
		this.zakazniciData = zakazniciData;
		this.zamestnanciData = zamestnanciData;
		this.uklidData = uklidData;
		this.client = client;
		this.myUI = myUI;
		addComponents(pocetTukanuField, velikostField, save);
		setSizeUndefined();
	}

	private void add() {
		Integer pocetTukanu = Integer.parseInt(pocetTukanuField.getValue());
		Float velikost = Float.parseFloat(velikostField.getValue());
		String vybaveni = vybaveniField.getValue();
		KlecEntity klec = new KlecEntity(0, pocetTukanu, velikost, vybaveni, 0);
		client.create_JSON(klec);
		KlecDTO klecDTO = client.findAllKlece_JSON(KlecDTO.class);
		kleceData = klecDTO.getKlece();
		myUI.setKleceData(kleceData);
		myUI.refreshGrids();
	}
}
