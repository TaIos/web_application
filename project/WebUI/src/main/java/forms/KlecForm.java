package forms;

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

	private TextField pocetTukanuField = new TextField("Pocet tukanu");
	private TextField velikostField = new TextField("Velikost v m3");
	private TextField vybaveniField = new TextField("Vybaveni");

	private MyUI myUI;

	private Button save = new Button("pridat", e -> {
		add();
	});

	public KlecForm(MyUI myUI) {
		this.myUI = myUI;
		addComponents(pocetTukanuField, velikostField, vybaveniField, save);
		setSizeUndefined();
	}

	private void add() {
		Integer pocetTukanu = Integer.parseInt(pocetTukanuField.getValue());
		Float velikost = Float.parseFloat(velikostField.getValue());
		String vybaveni = vybaveniField.getValue();

		KlecEntity klec = new KlecEntity(0, pocetTukanu, velikost, vybaveni, 0);

		myUI.getKlecJerseyClient().create_JSON(klec);
		myUI.setKleceData(myUI.getKlecJerseyClient().findAllKlece_JSON(KlecDTO.class).getKlece());
		myUI.refreshGrids();
	}
}
