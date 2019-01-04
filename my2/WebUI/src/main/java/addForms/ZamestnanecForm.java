package addForms;

import clients.ZamestnanecJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import ui.MyUI;

public class ZamestnanecForm extends FormLayout {

	private TextField jmeno = new TextField("Jmeno");
	private TextField prijmeni = new TextField("Prijmeni");
	private TextField adresa = new TextField("Adresa");
	private TextField rodneCislo = new TextField("Rodne cislo");
	private TextField cisloPozice = new TextField("Cislo pozice");
	private TextField email = new TextField("Email");

	private Button save = new Button("pridat");

	private ZamestnanecJerseyClient client;
	private MyUI myUI;

	public ZamestnanecForm(ZamestnanecJerseyClient client, MyUI myUI) {
		this.client = client;
		this.myUI = myUI;
		addComponents(jmeno, prijmeni, adresa, rodneCislo, cisloPozice, email, save);
		setSizeUndefined();
	}

}
