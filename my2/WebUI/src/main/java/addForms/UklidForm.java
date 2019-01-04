package addForms;

import clients.UklidJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import ui.MyUI;

public class UklidForm extends FormLayout {

	private TextField cisloZakaznika = new TextField("Cislo zamestnance");
	private TextField cisloKlece = new TextField("Cislo klece");

	private Button save = new Button("pridat");

	private UklidJerseyClient client;
	private MyUI myUI;

	public UklidForm(UklidJerseyClient client, MyUI myUI) {
		this.client = client;
		this.myUI = myUI;
		addComponents(cisloZakaznika, cisloKlece, save);
		setSizeUndefined();
	}

}
