package ui;

import addForms.KlecForm;
import addForms.ObjednavkaForm;
import addForms.UklidForm;
import addForms.ZakaznikForm;
import addForms.ZamestnanecForm;
import org.apache.commons.lang3.StringUtils;
import clients.KlecJerseyClient;
import clients.ObjednavkyJerseyClient;
import clients.UklidJerseyClient;
import clients.ZakaznikJerseyClient;
import clients.ZamestnanecJerseyClient;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.themes.ValoTheme;
import dto.KlecDTO;
import dto.ObjednavkaDTO;
import dto.UklidDTO;
import dto.ZakaznikDTO;
import dto.ZamestnanecDTO;
import entity.KlecEntity;
import entity.ObjednavkaEntity;
import entity.UklidEntity;
import entity.ZakaznikEntity;
import entity.ZamestnanecEntity;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
public class MyUI extends UI {

	int cnt = 0;
	int added = 0;

	private List<KlecEntity> kleceData;
	private List<ObjednavkaEntity> objednavkyData;
	private List<ZakaznikEntity> zakazniciData;
	private List<ZamestnanecEntity> zamestnanciData;
	private List<UklidEntity> uklidData;

	KlecJerseyClient klecJerseyClient;
	ObjednavkyJerseyClient objednavkyJerseyClient;
	ZakaznikJerseyClient zakaznikJerseyClient;
	ZamestnanecJerseyClient zamestnanecJerseyClient;
	UklidJerseyClient uklidJerseyClient;

	VerticalLayout defaultLayout;
	VerticalLayout klecLayout;
	VerticalLayout objednavkaLayout;
	VerticalLayout zakaznikLayout;
	VerticalLayout zamestnanecLayout;
	VerticalLayout uklidLayout;

	Grid<KlecEntity> gridKlec;
	Grid<ObjednavkaEntity> gridObjednavky;
	Grid<ZakaznikEntity> gridZakaznici;
	Grid<ZamestnanecEntity> gridZamestnanec;
	Grid<UklidEntity> gridUklid;

	private void fetchData() throws Exception {
		klecJerseyClient = new KlecJerseyClient();
		objednavkyJerseyClient = new ObjednavkyJerseyClient();
		zakaznikJerseyClient = new ZakaznikJerseyClient();
		zamestnanecJerseyClient = new ZamestnanecJerseyClient();
		uklidJerseyClient = new UklidJerseyClient();

		KlecDTO klecDTO = klecJerseyClient.findAllKlece_JSON(KlecDTO.class);
		ObjednavkaDTO objednavkaDTO = objednavkyJerseyClient.findAllObjednavky_JSON(ObjednavkaDTO.class);
		ZakaznikDTO zakaznikDTO = zakaznikJerseyClient.findAllZakazniky_JSON(ZakaznikDTO.class);
		ZamestnanecDTO zamestnanecDTO = zamestnanecJerseyClient.findAllZamestnance_JSON(ZamestnanecDTO.class);
		UklidDTO uklidDTO = uklidJerseyClient.findAllUklidy_JSON(UklidDTO.class);

		kleceData = klecDTO.getKlece();
		objednavkyData = objednavkaDTO.getObjednavky();
		zakazniciData = zakaznikDTO.getZakaznici();
		zamestnanciData = zamestnanecDTO.getZamestnanci();
		uklidData = uklidDTO.getUklid();
	}

	private void initLayouts() {
		createLayouts();
		createAddSwitchButtons();
		createAddddHeadings();
		createAddDataGrids();
	}

	private void createLayouts() {
		boolean visibility = true;

		klecLayout = new VerticalLayout();
		klecLayout.setSizeFull();
		klecLayout.setVisible(visibility);

		objednavkaLayout = new VerticalLayout();
		objednavkaLayout.setSizeFull();
		objednavkaLayout.setVisible(visibility);

		zakaznikLayout = new VerticalLayout();
		zakaznikLayout.setSizeFull();
		zakaznikLayout.setVisible(visibility);

		zamestnanecLayout = new VerticalLayout();
		zamestnanecLayout.setSizeFull();
		zamestnanecLayout.setVisible(visibility);

		uklidLayout = new VerticalLayout();
		uklidLayout.setSizeFull();
		uklidLayout.setVisible(visibility);

		defaultLayout = new VerticalLayout();
		defaultLayout.setSizeFull();
		defaultLayout.setVisible(visibility);

	}

	private void createAddddHeadings() {

		final Label headKlec = new Label("Klece");
		headKlec.addStyleName(ValoTheme.LABEL_H1);
		klecLayout.addComponent(headKlec);
		klecLayout.setComponentAlignment(headKlec, Alignment.TOP_CENTER);

		final Label headObjednavka = new Label("Objednavky");
		headObjednavka.addStyleName(ValoTheme.LABEL_H1);
		objednavkaLayout.addComponent(headObjednavka);
		objednavkaLayout.setComponentAlignment(headObjednavka, Alignment.TOP_CENTER);

		final Label headZakaznik = new Label("Zakaznici");
		headZakaznik.addStyleName(ValoTheme.LABEL_H1);
		zakaznikLayout.addComponent(headZakaznik);
		zakaznikLayout.setComponentAlignment(headZakaznik, Alignment.TOP_CENTER);

		final Label headZamestnanec = new Label("Zamestnanci");
		headZamestnanec.addStyleName(ValoTheme.LABEL_H1);
		zamestnanecLayout.addComponent(headZamestnanec);
		zamestnanecLayout.setComponentAlignment(headZamestnanec, Alignment.TOP_CENTER);

		final Label headUklid = new Label("Uklid");
		headUklid.addStyleName(ValoTheme.LABEL_H1);
		uklidLayout.addComponent(headUklid);
		uklidLayout.setComponentAlignment(headUklid, Alignment.TOP_CENTER);
	}

	private void createAddSwitchButtons() {
		Button buttonKlec1 = new Button("Klece", e -> {
			setContent(klecLayout);
		});
		Button buttonObjednavky1 = new Button("Objednavky", e -> {
			setContent(objednavkaLayout);
		});
		Button buttonZakaznik1 = new Button("Zakaznici", e -> {
			setContent(zakaznikLayout);
		});
		Button buttonZamestnanec1 = new Button("Zamestnanci", e -> {
			setContent(zamestnanecLayout);
		});
		Button buttonUklid1 = new Button("Uklid", e -> {
			setContent(uklidLayout);
		});

		Button buttonKlec2 = new Button("Klece", e -> {
			setContent(klecLayout);
		});
		Button buttonObjednavky2 = new Button("Objednavky", e -> {
			setContent(objednavkaLayout);
		});
		Button buttonZakaznik2 = new Button("Zakaznici", e -> {
			setContent(zakaznikLayout);
		});
		Button buttonZamestnanec2 = new Button("Zamestnanci", e -> {
			setContent(zamestnanecLayout);
		});
		Button buttonUklid2 = new Button("Uklid", e -> {
			setContent(uklidLayout);
		});

		Button buttonKlec3 = new Button("Klece", e -> {
			setContent(klecLayout);
		});
		Button buttonObjednavky3 = new Button("Objednavky", e -> {
			setContent(objednavkaLayout);
		});
		Button buttonZakaznik3 = new Button("Zakaznici", e -> {
			setContent(zakaznikLayout);
		});
		Button buttonZamestnanec3 = new Button("Zamestnanci", e -> {
			setContent(zamestnanecLayout);
		});
		Button buttonUklid3 = new Button("Uklid", e -> {
			setContent(uklidLayout);
		});

		Button buttonKlec4 = new Button("Klece", e -> {
			setContent(klecLayout);
		});
		Button buttonObjednavky4 = new Button("Objednavky", e -> {
			setContent(objednavkaLayout);
		});
		Button buttonZakaznik4 = new Button("Zakaznici", e -> {
			setContent(zakaznikLayout);
		});
		Button buttonZamestnanec4 = new Button("Zamestnanci", e -> {
			setContent(zamestnanecLayout);
		});
		Button buttonUklid4 = new Button("Uklid", e -> {
			setContent(uklidLayout);
		});

		Button buttonKlec5 = new Button("Klece", e -> {
			setContent(klecLayout);
		});
		Button buttonObjednavky5 = new Button("Objednavky", e -> {
			setContent(objednavkaLayout);
		});
		Button buttonZakaznik5 = new Button("Zakaznici", e -> {
			setContent(zakaznikLayout);
		});
		Button buttonZamestnanec5 = new Button("Zamestnanci", e -> {
			setContent(zamestnanecLayout);
		});
		Button buttonUklid5 = new Button("Uklid", e -> {
			setContent(uklidLayout);
		});

		HorizontalLayout switchButtons1 = new HorizontalLayout();
		switchButtons1.addComponents(buttonKlec1, buttonObjednavky1, buttonZakaznik1, buttonZamestnanec1, buttonUklid1);
		switchButtons1.setVisible(true);

		HorizontalLayout switchButtons2 = new HorizontalLayout();
		switchButtons2.addComponents(buttonKlec2, buttonObjednavky2, buttonZakaznik2, buttonZamestnanec2, buttonUklid2);
		switchButtons2.setVisible(true);

		HorizontalLayout switchButtons3 = new HorizontalLayout();
		switchButtons3.addComponents(buttonKlec3, buttonObjednavky3, buttonZakaznik3, buttonZamestnanec3, buttonUklid3);
		switchButtons3.setVisible(true);

		HorizontalLayout switchButtons4 = new HorizontalLayout();
		switchButtons4.addComponents(buttonKlec4, buttonObjednavky4, buttonZakaznik4, buttonZamestnanec4, buttonUklid4);
		switchButtons4.setVisible(true);

		HorizontalLayout switchButtons5 = new HorizontalLayout();
		switchButtons5.addComponents(buttonKlec5, buttonObjednavky5, buttonZakaznik5, buttonZamestnanec5, buttonUklid5);
		switchButtons5.setVisible(true);

		klecLayout.addComponent(switchButtons1);
		objednavkaLayout.addComponent(switchButtons2);
		zakaznikLayout.addComponent(switchButtons3);
		zamestnanecLayout.addComponent(switchButtons4);
		uklidLayout.addComponent(switchButtons5);
	}

	private void refreshGrids() {
		gridKlec.setItems(kleceData);
		gridObjednavky.setItems(objednavkyData);
		gridZakaznici.setItems(zakazniciData);
		gridZamestnanec.setItems(zamestnanciData);
		gridUklid.setItems(uklidData);
	}

	private void createAddDataGrids() {
		createAddKlecGrid();
		createAddObjednavkyGrid();
		createAddZakaznikGrid();
		createAddZamestnanecGrid();
		createAddUklidGrid();
	}

	private void createAddKlecGrid() {
		HorizontalLayout hl = new HorizontalLayout();

		gridKlec = new Grid<>(KlecEntity.class);
		gridKlec.setSizeFull();
		createKlecGridColumns();

		KlecForm klecForm = new KlecForm(this, klecJerseyClient);

		hl.addComponents(gridKlec, klecForm);
		hl.setExpandRatio(gridKlec, 10);
		hl.setSizeFull();

		klecLayout.addComponent(hl);
		klecLayout.setExpandRatio(hl, 10);
	}

	private void createKlecGridColumns() {
		gridKlec.setItems(kleceData);
		gridKlec.removeAllColumns();
		gridKlec.addColumn(KlecEntity::getId).setCaption("Cislo klece");
		gridKlec.addColumn(KlecEntity::getPocetTukanu).setCaption("Pocet tukanu");
		gridKlec.addColumn(KlecEntity::getVelikostKleceM3).setCaption("Velikost v m3");
		gridKlec.addColumn(KlecEntity::getVybaveni).setCaption("Vybaveni");

		gridKlec.addColumn(k -> "Uprait", new ButtonRenderer<>(
			e -> {
				updateKlec(e.getItem());
			}
		));

		gridKlec.addColumn(k -> "Smazat", new ButtonRenderer<>(
			e -> {
				removeKlec(e.getItem());
			}
		));

	}

	private void removeKlec(KlecEntity k) {

		if (k.getPocetTukanu() > 0) {
			Notification.show("Nelze smazat. V teto kleci zije " + k.getPocetTukanu() + " tukanu", Notification.Type.TRAY_NOTIFICATION);
			return;
		}

		Integer id = k.getId();

		// remove klec from klece
		klecJerseyClient.remove("" + k.getId());
		kleceData.remove(k);

		//collect uklid with klec present
		List<UklidEntity> found = new ArrayList<>();
		for (UklidEntity u : uklidData) {
			if (u.getId().getKlec_id().equals(k.getId())) {
				found.add(u);
			}
		}

		// remove klec from uklid
		for (UklidEntity u : found) {
			uklidJerseyClient.remove(u.getId().getZam_id() + "-" + u.getId().getKlec_id());
		}
		uklidData.removeAll(found);

		refreshGrids();
	}

	private void updateKlec(KlecEntity k) {

	}

	private void createAddObjednavkyGrid() {

		HorizontalLayout hl = new HorizontalLayout();

		gridObjednavky = new Grid<>(ObjednavkaEntity.class);
		gridObjednavky.setSizeFull();
		createObjednavkaGridColumns();

		ObjednavkaForm objednavkaForm = new ObjednavkaForm(objednavkyJerseyClient, this);

		hl.addComponents(gridObjednavky, objednavkaForm);
		hl.setExpandRatio(gridObjednavky, 10);
		hl.setSizeFull();

		objednavkaLayout.addComponent(hl);
		objednavkaLayout.setExpandRatio(hl, 10);
	}

	private void createObjednavkaGridColumns() {
		gridObjednavky.setItems(objednavkyData);
		gridObjednavky.removeAllColumns();
		gridObjednavky.addColumn(ObjednavkaEntity::getId).setCaption("Cislo objednavky");

		gridObjednavky.addColumn(o -> {
			ZakaznikEntity z = findZak(o.getIdZak());
			return z.getJmeno() + " " + z.getPrijmeni();
		}).setCaption("Jmeno zakaznika");

		gridObjednavky.addColumn(ObjednavkaEntity::getIdTukan).setCaption("Cislo tukana");
		gridObjednavky.addColumn(ObjednavkaEntity::getDatumVytvoreni).setCaption("Datum vytvoreni");
		gridObjednavky.addColumn(ObjednavkaEntity::getTypDopravy).setCaption("Typ dopravy");

		gridObjednavky.addColumn(k -> "Upravit", new ButtonRenderer<>(
			e -> {
				updateObjednavka(e.getItem());
			}
		));

		gridObjednavky.addColumn(k -> "Smazat", new ButtonRenderer<>(
			e -> {
				removeObjednavka(e.getItem());
			}
		));

	}

	private void removeObjednavka(ObjednavkaEntity o) {
		objednavkyJerseyClient.remove("" + o.getId());
		objednavkyData.remove(o);
		refreshGrids();
	}

	private void updateObjednavka(ObjednavkaEntity o) {

	}

	private void createAddZakaznikGrid() {
		HorizontalLayout hl = new HorizontalLayout();

		gridZakaznici = new Grid<>(ZakaznikEntity.class);
		gridZakaznici.setSizeFull();
		createZakaznikGridColumns();

		ZakaznikForm zakaznikForm = new ZakaznikForm(zakaznikJerseyClient, this);

		hl.addComponents(gridZakaznici, zakaznikForm);
		hl.setExpandRatio(gridZakaznici, 10);
		hl.setSizeFull();

		zakaznikLayout.addComponent(hl);
		zakaznikLayout.setExpandRatio(hl, 10);
	}

	private void createZakaznikGridColumns() {
		gridZakaznici.setItems(zakazniciData);
		gridZakaznici.removeAllColumns();
		gridZakaznici.addColumn(ZakaznikEntity::getJmeno).setCaption("Jmeno");
		gridZakaznici.addColumn(ZakaznikEntity::getPrijmeni).setCaption("Prijmeni");
		gridZakaznici.addColumn(ZakaznikEntity::getId).setCaption("Cislo zakaznika");
		gridZakaznici.addColumn(ZakaznikEntity::getDorucovaciAdresa).setCaption("Bydliste");
		gridZakaznici.addColumn(ZakaznikEntity::getEmail).setCaption("email");

		gridZakaznici.addColumn(z -> {

			return StringUtils.join(getObjednavky(z), ",");
		}
		).setCaption("Cisla objednavek");

		gridZakaznici.addColumn(z -> "Upravit", new ButtonRenderer<>(
			e -> {
				updateZakaznik(e.getItem());
			}
		));

		gridZakaznici.addColumn(z -> "Smazat", new ButtonRenderer<>(
			e -> {
				removeZakaznik(e.getItem());
			}
		));
	}

	private void removeZakaznik(ZakaznikEntity z) {
		if (getObjednavky(z).size() > 0) {
			Notification.show("Nelze smazat. Tento zakaznik ma objednavky.");
			return;
		}
		zakaznikJerseyClient.remove(z.getId() + "");
		zakazniciData.remove(z);
		refreshGrids();
	}

	private void updateZakaznik(ZakaznikEntity z) {

	}

	private void createAddZamestnanecGrid() {
		HorizontalLayout hl = new HorizontalLayout();

		gridZamestnanec = new Grid<>(ZamestnanecEntity.class);
		gridZamestnanec.setSizeFull();
		createZamestnanecGridColumns();

		ZamestnanecForm zamestnanecForm = new ZamestnanecForm(zamestnanecJerseyClient, this);

		hl.addComponents(gridZamestnanec, zamestnanecForm);
		hl.setExpandRatio(gridZamestnanec, 10);
		hl.setSizeFull();

		zamestnanecLayout.addComponent(hl);
		zamestnanecLayout.setExpandRatio(hl, 10);
	}

	private void createZamestnanecGridColumns() {
		gridZamestnanec.setItems(zamestnanciData);
		gridZamestnanec.removeAllColumns();
		gridZamestnanec.addColumn(ZamestnanecEntity::getJmeno).setCaption("Jmeno");
		gridZamestnanec.addColumn(ZamestnanecEntity::getPrijmeni).setCaption("Prijmeni");
		gridZamestnanec.addColumn(ZamestnanecEntity::getId).setCaption("Cislo zamestnance");
		gridZamestnanec.addColumn(ZamestnanecEntity::getAdresa).setCaption("Bydliste");
		gridZamestnanec.addColumn(ZamestnanecEntity::getRodneCislo).setCaption("Rodne cislo");
		gridZamestnanec.addColumn(ZamestnanecEntity::getPozice_id).setCaption("Cislo pozice");

		gridZamestnanec.addColumn(z -> "Upravit", new ButtonRenderer<>(
			e -> {
				updateZamestnanec(e.getItem());
			}
		));

		gridZamestnanec.addColumn(z -> "Smazat", new ButtonRenderer<>(
			e -> {
				removeZamestnanec(e.getItem());
			}
		));
	}

	private void removeZamestnanec(ZamestnanecEntity z) {
		List<UklidEntity> found = new ArrayList<>();

		for (UklidEntity u : uklidData) {
			if (u.getId().getZam_id().equals(z.getId())) {
				found.add(u);

			}
		}
		// remove zamestnanec from uklid
		for (UklidEntity u : found) {
			uklidJerseyClient.remove(u.getId().getZam_id() + "-" + u.getId().getKlec_id());
		}
		uklidData.removeAll(found);

		zamestnanecJerseyClient.remove(z.getId() + "");
		zamestnanciData.remove(z);
		refreshGrids();
	}

	private void updateZamestnanec(ZamestnanecEntity z) {

	}

	private void createAddUklidGrid() {
		HorizontalLayout hl = new HorizontalLayout();

		gridUklid = new Grid<>(UklidEntity.class);
		gridUklid.setSizeFull();
		createUklidGridColumns();

		UklidForm uklidForm = new UklidForm(uklidJerseyClient, this);

		hl.addComponents(gridUklid, uklidForm);
		hl.setExpandRatio(gridUklid, 10);
		hl.setSizeFull();

		uklidLayout.addComponent(hl);
		uklidLayout.setExpandRatio(hl, 10);
	}

	private void createUklidGridColumns() {
		gridUklid.setItems(uklidData);
		gridUklid.removeAllColumns();

		gridUklid.addColumn(
			e -> {
				ZamestnanecEntity z = findZam(e.getZamestnanecID());
				return z.getJmeno() + " " + z.getPrijmeni();
			}
		).setCaption("Jmeno zamestnance");

		gridUklid.addColumn(UklidEntity::getKlecID).setCaption("Cislo klece");

		gridUklid.addColumn(z -> "Upravit", new ButtonRenderer<>(
			e -> {
				updateUklid(e.getItem());
			}
		));

		gridUklid.addColumn(z -> "Smazat", new ButtonRenderer<>(
			e -> {
				removeUklid(e.getItem());
			}
		));
	}

	private void removeUklid(UklidEntity u) {
		uklidJerseyClient.remove(u.getId().getZam_id() + "-" + u.getId().getKlec_id());
		uklidData.remove(u);
		refreshGrids();
	}

	private void updateUklid(UklidEntity u) {

	}

	private ZamestnanecEntity findZam(int id) {
		for (ZamestnanecEntity z : zamestnanciData) {
			if (z.getId().equals(id)) {
				return z;
			}
		}
		return null;
	}

	private ZakaznikEntity findZak(int id) {
		for (ZakaznikEntity z : zakazniciData) {
			if (z.getId().equals(id)) {
				return z;
			}
		}
		return null;
	}

	private List<Integer> getObjednavky(ZakaznikEntity z) {
		ArrayList<Integer> obj = new ArrayList();
		int id = z.getId();
		for (ObjednavkaEntity o : objednavkyData) {
			if (o.getIdZak().equals(id)) {
				obj.add(o.getId());
			}
		}
		return obj;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		try {
			fetchData();
		} catch (Exception e) {
			Label error = new Label(e.toString());
			defaultLayout = new VerticalLayout();
			defaultLayout.addComponent(error);
			setContent(defaultLayout);
			return;
		}

		initLayouts();
		setContent(klecLayout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
