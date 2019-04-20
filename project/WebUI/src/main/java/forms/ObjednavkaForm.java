package forms;

import clients.KlecJerseyClient;
import clients.ObjednavkyJerseyClient;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import dto.ObjednavkaDTO;
import dto.ZakaznikDTO;
import entity.KlecEntity;
import entity.ObjednavkaEntity;
import entity.UklidEntity;
import entity.ZakaznikEntity;
import entity.ZamestnanecEntity;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import ui.MyUI;

public class ObjednavkaForm extends FormLayout {

	private TextField cisloZakaznikaField = new TextField("Cislo zakaznika");
	private TextField cisloTukanaField = new TextField("Cislo tukana");
	private DateField datumVytvoreniField = new DateField("Datum vytvoreni");
	private TextField typDopravyField = new TextField("Typ dopravy");

	private MyUI myUI;

	private Button save = new Button("pridat", e -> {
		add();
	});

	public ObjednavkaForm(MyUI myUI) {
		this.myUI = myUI;
		addComponents(cisloZakaznikaField, cisloTukanaField, datumVytvoreniField, typDopravyField);
		setSizeUndefined();
	}

	private void add() {
		Integer cisloZakaznika = Integer.parseInt(cisloZakaznikaField.getValue());
		Integer cisloTukana = Integer.parseInt(cisloTukanaField.getValue());
		Date datumVytvoreni = Date.from(datumVytvoreniField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		String typDopravy = typDopravyField.getValue();

		ObjednavkaEntity objednavka = new ObjednavkaEntity(0, typDopravy, datumVytvoreni, datumVytvoreni, cisloTukana, cisloZakaznika);

		myUI.getObjednavkyJerseyClient().create_JSON(objednavka);
		myUI.setObjednavkyData(myUI.getObjednavkyJerseyClient().findAllObjednavky_JSON(ObjednavkaDTO.class).getObjednavky());
		myUI.refreshGrids();
	}
}
