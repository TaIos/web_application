package addForms;

import clients.KlecJerseyClient;
import clients.ObjednavkyJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import entity.KlecEntity;
import entity.ObjednavkaEntity;
import entity.UklidEntity;
import entity.ZakaznikEntity;
import entity.ZamestnanecEntity;
import ui.MyUI;

public class ObjednavkaForm extends FormLayout {

	Grid<KlecEntity> gridKlec;
	Grid<ObjednavkaEntity> gridObjednavky;
	Grid<ZakaznikEntity> gridZakaznici;
	Grid<ZamestnanecEntity> gridZamestnanec;
	Grid<UklidEntity> gridUklid;

	private TextField cisloZakaznika = new TextField("Cislo zakaznika");
	private TextField cisloTukana = new TextField("Cislo tukana");
	private DateField datumVytvoreni = new DateField("Datum vytvoreni");
	private TextField typDopravy = new TextField("Typ dopravy");

	private Button save = new Button("pridat");

	private ObjednavkyJerseyClient client;
	private MyUI myUI;

	public ObjednavkaForm(Grid<KlecEntity> gridKlec, Grid<ObjednavkaEntity> gridObjednavky, Grid<ZakaznikEntity> gridZakaznici, Grid<ZamestnanecEntity> gridZamestnanec, Grid<UklidEntity> gridUklid, ObjednavkyJerseyClient client, MyUI myUI) {
		this.gridKlec = gridKlec;
		this.gridObjednavky = gridObjednavky;
		this.gridZakaznici = gridZakaznici;
		this.gridZamestnanec = gridZamestnanec;
		this.gridUklid = gridUklid;
		this.client = client;
		this.myUI = myUI;
		addComponents(cisloZakaznika, cisloTukana, datumVytvoreni, typDopravy);
		setSizeUndefined();
	}

}
