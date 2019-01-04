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
import ui.MyUI;

public class UklidForm extends FormLayout {

	Grid<KlecEntity> gridKlec;
	Grid<ObjednavkaEntity> gridObjednavky;
	Grid<ZakaznikEntity> gridZakaznici;
	Grid<ZamestnanecEntity> gridZamestnanec;
	Grid<UklidEntity> gridUklid;

	private TextField cisloZakaznika = new TextField("Cislo zamestnance");
	private TextField cisloKlece = new TextField("Cislo klece");

	private Button save = new Button("pridat");

	private UklidJerseyClient client;
	private MyUI myUI;

	public UklidForm(Grid<KlecEntity> gridKlec, Grid<ObjednavkaEntity> gridObjednavky, Grid<ZakaznikEntity> gridZakaznici, Grid<ZamestnanecEntity> gridZamestnanec, Grid<UklidEntity> gridUklid, UklidJerseyClient client, MyUI myUI) {
		this.gridKlec = gridKlec;
		this.gridObjednavky = gridObjednavky;
		this.gridZakaznici = gridZakaznici;
		this.gridZamestnanec = gridZamestnanec;
		this.gridUklid = gridUklid;
		this.client = client;
		this.myUI = myUI;
		addComponents(cisloZakaznika, cisloKlece, save);
		setSizeUndefined();
	}

}
