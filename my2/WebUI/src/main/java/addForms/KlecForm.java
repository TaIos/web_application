package addForms;

import clients.KlecJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import entity.KlecEntity;
import ui.MyUI;

public class KlecForm extends FormLayout {

	private TextField pocetTukanu = new TextField("Pocet tukanu");
	private TextField velikost = new TextField("Velikost v m3");
	private TextField vybaveni = new TextField("Vybaveni");

	private Button save = new Button("pridat");

	private KlecJerseyClient client;
	private MyUI myUI;

	public KlecForm(MyUI myUI, KlecJerseyClient client) {
		this.myUI = myUI;
		this.client = client;
		addComponents(pocetTukanu, velikost, save);
		setSizeUndefined();
	}
}
