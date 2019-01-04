package addForms;

import clients.KlecJerseyClient;
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

public class KlecForm extends FormLayout {

	Grid<KlecEntity> gridKlec;
	Grid<ObjednavkaEntity> gridObjednavky;
	Grid<ZakaznikEntity> gridZakaznici;
	Grid<ZamestnanecEntity> gridZamestnanec;
	Grid<UklidEntity> gridUklid;

	private TextField pocetTukanu = new TextField("Pocet tukanu");
	private TextField velikost = new TextField("Velikost v m3");
	private TextField vybaveni = new TextField("Vybaveni");

	private Button save = new Button("pridat");

	private KlecJerseyClient client;
	private MyUI myUI;

	public KlecForm(Grid<KlecEntity> gridKlec, Grid<ObjednavkaEntity> gridObjednavky, Grid<ZakaznikEntity> gridZakaznici, Grid<ZamestnanecEntity> gridZamestnanec, Grid<UklidEntity> gridUklid, KlecJerseyClient client, MyUI myUI) {
		this.gridKlec = gridKlec;
		this.gridObjednavky = gridObjednavky;
		this.gridZakaznici = gridZakaznici;
		this.gridZamestnanec = gridZamestnanec;
		this.gridUklid = gridUklid;
		this.client = client;
		this.myUI = myUI;
		addComponents(pocetTukanu, velikost, save);
		setSizeUndefined();
	}

}
