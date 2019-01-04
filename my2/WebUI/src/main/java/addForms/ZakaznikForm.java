package addForms;

import clients.KlecJerseyClient;
import clients.ZakaznikJerseyClient;
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

public class ZakaznikForm extends FormLayout {

	Grid<KlecEntity> gridKlec;
	Grid<ObjednavkaEntity> gridObjednavky;
	Grid<ZakaznikEntity> gridZakaznici;
	Grid<ZamestnanecEntity> gridZamestnanec;
	Grid<UklidEntity> gridUklid;

	private TextField jmeno = new TextField("Jmeno");
	private TextField prijmeni = new TextField("Prijmeni");
	private TextField adresa = new TextField("Bydliste");
	private TextField email = new TextField("Email");

	private Button save = new Button("pridat");

	private ZakaznikJerseyClient client;
	private MyUI myUI;

	public ZakaznikForm(Grid<KlecEntity> gridKlec, Grid<ObjednavkaEntity> gridObjednavky, Grid<ZakaznikEntity> gridZakaznici, Grid<ZamestnanecEntity> gridZamestnanec, Grid<UklidEntity> gridUklid, ZakaznikJerseyClient client, MyUI myUI) {
		this.gridKlec = gridKlec;
		this.gridObjednavky = gridObjednavky;
		this.gridZakaznici = gridZakaznici;
		this.gridZamestnanec = gridZamestnanec;
		this.gridUklid = gridUklid;
		this.client = client;
		this.myUI = myUI;
		addComponents(jmeno, prijmeni, adresa, email, save);
		setSizeUndefined();
	}

}
