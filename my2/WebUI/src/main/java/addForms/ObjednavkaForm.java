package addForms;

import clients.ObjednavkyJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import ui.MyUI;

public class ObjednavkaForm extends FormLayout {

	private TextField cisloZakaznika = new TextField("Cislo zakaznika");
	private TextField cisloTukana = new TextField("Cislo tukana");
	private DateField datumVytvoreni = new DateField("Datum vytvoreni");
	private TextField typDopravy = new TextField("Typ dopravy");

	private Button save = new Button("pridat");

	private ObjednavkyJerseyClient client;
	private MyUI myUI;

	public ObjednavkaForm(ObjednavkyJerseyClient client, MyUI myUI) {
		this.client = client;
		this.myUI = myUI;
		addComponents(cisloZakaznika, cisloTukana, datumVytvoreni, typDopravy);
		setSizeUndefined();
	}
}
