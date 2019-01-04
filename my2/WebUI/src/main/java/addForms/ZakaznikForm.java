package addForms;

import clients.ZakaznikJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import ui.MyUI;

public class ZakaznikForm extends FormLayout {

	private TextField jmeno = new TextField("Jmeno");
	private TextField prijmeni = new TextField("Prijmeni");
	private TextField adresa = new TextField("Bydliste");
	private TextField email = new TextField("Email");

	private Button save = new Button("pridat");

	private ZakaznikJerseyClient client;
	private MyUI myUI;

	public ZakaznikForm(ZakaznikJerseyClient client, MyUI myUI) {
		this.client = client;
		this.myUI = myUI;
		addComponents(jmeno, prijmeni, adresa, email, save);
		setSizeUndefined();
	}

}
