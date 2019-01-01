package ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.DateRenderer;
import cz.cvut.fit.tjv.cv.tvseries.domain.SerieDTO;
import cz.cvut.fit.tjv.cv.tvseries.rest_client.SerieClient;
import java.text.DateFormat;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("seriestheme")
public class SeriesUI extends UI {

    private final SerieClient serieClient = SerieClient.getInstance();
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        Label seriesHead = new Label("Series");
        
        Grid<SerieDTO> seriesGrid = new Grid<>();
        seriesGrid.addColumn(s -> s.getEditorId()).setCaption("Editor ID");
        seriesGrid.addColumn(SerieDTO::getTitle).setCaption("Title");
        seriesGrid.addColumn(SerieDTO::getAdded, new DateRenderer(
                DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)
        )).setCaption("When Added");
        seriesGrid.addColumn(s -> "Delete", new ButtonRenderer<>(e -> {
            serieClient.delete(e.getItem().getTitle(), e.getItem().getEditorId());
            seriesGrid.setItems(serieClient.retrieveAllJson());
        }));
        
        seriesGrid.setItems(serieClient.retrieveAllJson());
        
        layout.addComponents(seriesHead, seriesGrid);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "SeriesUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = SeriesUI.class, productionMode = false)
    public static class SeriesUIServlet extends VaadinServlet {
    }
}
