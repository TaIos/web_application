package ui;

import org.apache.commons.lang3.StringUtils;
import clients.KlecJerseyClient;
import clients.ObjednavkyJerseyClient;
import clients.UklidJerseyClient;
import clients.ZakaznikJerseyClient;
import clients.ZamestnanecJerseyClient;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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
	GridLayout klecLayout;
	GridLayout objednavkaLayout;
	GridLayout zakaznikLayout;
	GridLayout zamestnanecLayout;
	GridLayout uklidLayout;

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
		addHeadings();
		createDataGrids();
		addSwitchButtons();
		setSizes();
	}

	private void createLayouts() {
		int w = 2;
		int h = 2;
		boolean visibility = true;

		klecLayout = new GridLayout(w, h);
		klecLayout.setSizeFull();
		klecLayout.setVisible(visibility);

		objednavkaLayout = new GridLayout(w, h);
		objednavkaLayout.setSizeFull();
		objednavkaLayout.setVisible(visibility);

		zakaznikLayout = new GridLayout(w, h);
		zakaznikLayout.setSizeFull();
		zakaznikLayout.setVisible(visibility);

		zamestnanecLayout = new GridLayout(w, h);
		zamestnanecLayout.setSizeFull();
		zamestnanecLayout.setVisible(visibility);

		uklidLayout = new GridLayout(w, h);
		uklidLayout.setSizeFull();
		uklidLayout.setVisible(visibility);

		defaultLayout = new VerticalLayout();
		defaultLayout.setSizeFull();
		defaultLayout.setVisible(visibility);

	}

	private void addHeadings() {
		int x = 1;
		int y = 0;

		final Label headKlec = new Label("Klece");
		headKlec.addStyleName(ValoTheme.LABEL_H1);
		klecLayout.addComponent(headKlec, x, y);
		klecLayout.setComponentAlignment(headKlec, Alignment.TOP_CENTER);

		final Label headObjednavka = new Label("Objednavky");
		headObjednavka.addStyleName(ValoTheme.LABEL_H1);
		objednavkaLayout.addComponent(headObjednavka, x, y);
		objednavkaLayout.setComponentAlignment(headObjednavka, Alignment.TOP_CENTER);

		final Label headZakaznik = new Label("Zakaznici");
		headZakaznik.addStyleName(ValoTheme.LABEL_H1);
		zakaznikLayout.addComponent(headZakaznik, x, y);
		zakaznikLayout.setComponentAlignment(headZakaznik, Alignment.TOP_CENTER);

		final Label headZamestnanec = new Label("Zamestnanci");
		headZamestnanec.addStyleName(ValoTheme.LABEL_H1);
		zamestnanecLayout.addComponent(headZamestnanec, x, y);
		zamestnanecLayout.setComponentAlignment(headZamestnanec, Alignment.TOP_CENTER);

		final Label headUklid = new Label("Uklid");
		headUklid.addStyleName(ValoTheme.LABEL_H1);
		uklidLayout.addComponent(headUklid, x, y);
		uklidLayout.setComponentAlignment(headUklid, Alignment.TOP_CENTER);
	}

	private void addSwitchButtons() {
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

		int x = 0;
		int y = 0;
		klecLayout.addComponent(switchButtons1, x, y);
		objednavkaLayout.addComponent(switchButtons2, x, y);
		zakaznikLayout.addComponent(switchButtons3, x, y);
		zamestnanecLayout.addComponent(switchButtons4, x, y);
		uklidLayout.addComponent(switchButtons5, x, y);
	}

	// TODO
	private void setSizes() {
		int x = 1;
		int y = 5;

		/*
		klecLayout.setColumnExpandRatio(0, x);
		klecLayout.setColumnExpandRatio(1, y);
		klecLayout.setRowExpandRatio(0, 1);
		klecLayout.setRowExpandRatio(1, 10);
		 */
	}

	private void refreshGrids() {

		gridKlec.setItems(kleceData);
		gridObjednavky.setItems(objednavkyData);
		gridZakaznici.setItems(zakazniciData);
		gridZamestnanec.setItems(zamestnanciData);
		gridUklid.setItems(uklidData);
	}

	private void createDataGrids() {
		createKlecGrid();
		createObjednavkyGrid();
		createZakaznikGrid();
		createZamestnanecGrid();
		createUklidGrid();
	}

	private void createKlecGrid() {

		gridKlec = new Grid<>(KlecEntity.class);
		createKlecGridColumns();
		int x = 1;
		int y = 1;
		klecLayout.addComponent(gridKlec, x, y);
		klecLayout.setComponentAlignment(gridKlec, Alignment.TOP_CENTER);
	}

	private void createKlecGridColumns() {
		gridKlec.setItems(kleceData);
		gridKlec.removeAllColumns();
		gridKlec.addColumn(KlecEntity::getId).setCaption("Cislo klece");
		gridKlec.addColumn(KlecEntity::getPocetTukanu).setCaption("Pocet tukanu");
		gridKlec.addColumn(KlecEntity::getVelikostKleceM3).setCaption("Velikost v m3");
		gridKlec.addColumn(KlecEntity::getVybaveni).setCaption("Vybaveni");

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

	private void createObjednavkyGrid() {
		int x = 1;
		int y = 1;

		gridObjednavky = new Grid<>(ObjednavkaEntity.class);
		createObjednavkaGridColumns();
		objednavkaLayout.addComponent(gridObjednavky, x, y);
		objednavkaLayout.setComponentAlignment(gridObjednavky, Alignment.TOP_CENTER);
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

	private void createZakaznikGrid() {
		int x = 1;
		int y = 1;

		gridZakaznici = new Grid<>(ZakaznikEntity.class);
		createZakaznikGridColumns();
		zakaznikLayout.addComponent(gridZakaznici, x, y);
		zakaznikLayout.setComponentAlignment(gridZakaznici, Alignment.TOP_CENTER);
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

	private void createZamestnanecGrid() {
		int x = 1;
		int y = 1;

		gridZamestnanec = new Grid<>(ZamestnanecEntity.class);
		gridZamestnanec.setItems(zamestnanciData);
		createZamestnanecGridColumns();
		zamestnanecLayout.addComponent(gridZamestnanec, x, y);
		zamestnanecLayout.setComponentAlignment(gridZamestnanec, Alignment.TOP_CENTER);
	}

	private void createZamestnanecGridColumns() {
		gridZamestnanec.removeAllColumns();
		gridZamestnanec.addColumn(ZamestnanecEntity::getJmeno).setCaption("Jmeno");
		gridZamestnanec.addColumn(ZamestnanecEntity::getPrijmeni).setCaption("Prijmeni");
		gridZamestnanec.addColumn(ZamestnanecEntity::getId).setCaption("Cislo zamestnance");
		gridZamestnanec.addColumn(ZamestnanecEntity::getAdresa).setCaption("Bydliste");
		gridZamestnanec.addColumn(ZamestnanecEntity::getRodneCislo).setCaption("Rodne cislo");
		gridZamestnanec.addColumn(ZamestnanecEntity::getPozice_id).setCaption("Cislo pozice");

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

	private void createUklidGrid() {
		int x = 1;
		int y = 1;

		gridUklid = new Grid<>(UklidEntity.class);
		createUklidGridColumns();
		uklidLayout.addComponent(gridUklid, x, y);
		uklidLayout.setComponentAlignment(gridUklid, Alignment.TOP_CENTER);
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
