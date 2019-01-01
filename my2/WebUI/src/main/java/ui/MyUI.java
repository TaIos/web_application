package ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		// CREATE LAYOUTS FOR EACH COMPONENT
		GridLayout defaultLayout = new GridLayout(3, 1);
		defaultLayout.setSizeFull();
		defaultLayout.setVisible(true);

		GridLayout klecLayout = new GridLayout(3, 1);
		klecLayout.setSizeFull();
		klecLayout.setVisible(false);

		GridLayout objednavkaLayout = new GridLayout(3, 1);
		objednavkaLayout.setSizeFull();
		objednavkaLayout.setVisible(false);

		GridLayout zakaznikLayout = new GridLayout(3, 1);
		zakaznikLayout.setSizeFull();
		zakaznikLayout.setVisible(false);

		GridLayout zamestnanecLayout = new GridLayout(3, 1);
		zamestnanecLayout.setSizeFull();
		zamestnanecLayout.setVisible(false);

		// LAYOUTS FUNCTIONALITY=======================================================
		// ADD HEADINGS TO EACH LAYOUTS
		final Label headDefault = new Label("DEFAULT LAYOUT");
		headDefault.addStyleName(ValoTheme.LABEL_H1);
		defaultLayout.addComponent(headDefault, 1, 0);
		defaultLayout.setComponentAlignment(headDefault, Alignment.MIDDLE_CENTER);

		final Label headKlec = new Label("Klece");
		headKlec.addStyleName(ValoTheme.LABEL_H1);
		klecLayout.addComponent(headKlec, 1, 0);
		klecLayout.setComponentAlignment(headKlec, Alignment.MIDDLE_CENTER);

		final Label headObjednavka = new Label("Objednavky");
		headObjednavka.addStyleName(ValoTheme.LABEL_H1);
		objednavkaLayout.addComponent(headObjednavka, 1, 0);
		objednavkaLayout.setComponentAlignment(headObjednavka, Alignment.MIDDLE_CENTER);

		final Label headZakaznik = new Label("Zakaznici");
		headZakaznik.addStyleName(ValoTheme.LABEL_H1);
		zakaznikLayout.addComponent(headZakaznik, 1, 0);
		zakaznikLayout.setComponentAlignment(headZakaznik, Alignment.MIDDLE_CENTER);

		final Label headZamestnanec = new Label("Zamestnanci");
		headZamestnanec.addStyleName(ValoTheme.LABEL_H1);
		zamestnanecLayout.addComponent(headZamestnanec, 1, 0);
		zamestnanecLayout.setComponentAlignment(headZamestnanec, Alignment.MIDDLE_CENTER);

		// ADD LAYOUTS TO MAIN FRAME
		layout.addComponent(defaultLayout);
		layout.addComponent(klecLayout);
		layout.addComponent(objednavkaLayout);
		layout.addComponent(zakaznikLayout);
		layout.addComponent(zamestnanecLayout);

		//BUTTONS FOR DISPLAYING LAYOUTS===========================================
		// CREATE BUTTONS TO DISPLAY EACH LAYOUTS
		Button buttonKlec = new Button("Klece", e -> {
			klecLayout.setVisible(true);
			objednavkaLayout.setVisible(false);
			zakaznikLayout.setVisible(false);
			zamestnanecLayout.setVisible(false);
			defaultLayout.setVisible(false);
		});

		Button buttonObjednavky = new Button("Objednavky", e -> {
			objednavkaLayout.setVisible(true);
			klecLayout.setVisible(false);
			zakaznikLayout.setVisible(false);
			zamestnanecLayout.setVisible(false);
			defaultLayout.setVisible(false);
		});

		Button buttonZakaznik = new Button("Zakaznici", e -> {
			zakaznikLayout.setVisible(true);
			objednavkaLayout.setVisible(false);
			klecLayout.setVisible(false);
			zamestnanecLayout.setVisible(false);
			defaultLayout.setVisible(false);
		});

		Button buttonZamestnanec = new Button("Zamestnanci", e -> {
			zamestnanecLayout.setVisible(true);
			zakaznikLayout.setVisible(false);
			objednavkaLayout.setVisible(false);
			klecLayout.setVisible(false);
			defaultLayout.setVisible(false);
		});

		// ADD BUTTONS TO DISPLAY EACH LAYOUTS
		layout.addComponent(buttonKlec);
		layout.addComponent(buttonObjednavky);
		layout.addComponent(buttonZakaznik);
		layout.addComponent(buttonZamestnanec);
		//=======================================================================

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
