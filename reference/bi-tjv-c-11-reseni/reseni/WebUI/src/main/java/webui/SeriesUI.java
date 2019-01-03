package webui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateTimeToDateConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.DateRenderer;
import cz.cvut.fit.tjv.cv.tvseries.domain.PersonDTO;
import cz.cvut.fit.tjv.cv.tvseries.domain.SerieDTO;
import cz.cvut.fit.tjv.cv.tvseries.rest_client.PersonClient;
import cz.cvut.fit.tjv.cv.tvseries.rest_client.SerieClient;
import cz.cvut.fit.tjv.cv.tvseries.rest_client.SeriesServiceException;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("seriestheme")
public class SeriesUI extends UI {

    private final SerieClient serieClient = SerieClient.getInstance();
    private final PersonClient personClient = PersonClient.getInstance();
    private List<SerieDTO> series;
    private List<PersonDTO> persons;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        try {
            series = new ArrayList<>(Arrays.asList(serieClient.retrieveAllJson()));
            persons = new ArrayList<>(Arrays.asList(personClient.retrieveAllJson()));
        } catch (SeriesServiceException e) {
            Notification.show("Series service is not running " + e, Notification.Type.ERROR_MESSAGE);
            setContent(layout);
            return;
        }

        Label seriesHead = new Label("Series");

        Grid<SerieDTO> seriesGrid = new Grid<>(SerieDTO.class);
        seriesGrid.removeColumn("added");
        seriesGrid.addColumn("added", new DateRenderer(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)));
        seriesGrid.addColumn(s -> "Delete", new ButtonRenderer<>(e -> {
            serieClient.delete(e.getItem().getTitle(), e.getItem().getEditorId());
            series.remove(e.getItem());
            seriesGrid.setItems(series);
        }));

        seriesGrid.setItems(series);

        Label addSerieHead = new Label("Add/edit serie");
        TextField editorId = new TextField("Editor ID");
        TextField sTitle = new TextField("Serie title");
        DateTimeField added = new DateTimeField("Added");
        final Binder<SerieDTO> serieBinder = new Binder<>(SerieDTO.class);
        serieBinder.forField(editorId).asRequired().withConverter(new StringToIntegerConverter("Must be integer")).bind("editorId");
        serieBinder.forField(sTitle).asRequired().bind("title");
        serieBinder.forField(added).withConverter(new LocalDateTimeToDateConverter(ZoneId.systemDefault())).bind("added");
        seriesGrid.addSelectionListener(e -> {
            if (e.getFirstSelectedItem().isPresent()) {
                serieBinder.readBean(e.getFirstSelectedItem().get());
            }
        });
        HorizontalLayout addSerieLayout = new HorizontalLayout(editorId, sTitle, added);
        Button submitSerie = new Button("Add or edit serie", e -> {
            SerieDTO s = new SerieDTO();
            if (serieBinder.writeBeanIfValid(s)) {
                serieClient.createOrUpdateJson(s);
                series.clear();
                series.addAll(Arrays.asList(serieClient.retrieveAllJson()));
                seriesGrid.setItems(series);
            }
        });

        layout.addComponents(seriesHead, seriesGrid, addSerieHead, addSerieLayout, submitSerie);

        Label personsHead = new Label("Persons");

        Grid<PersonDTO> personsGrid = new Grid<>(PersonDTO.class);
        TextField personName = new TextField();
        personsGrid.setColumnOrder("id", "name", "favourites");
        personsGrid.getColumn("name").setEditorBinding(personsGrid.getEditor().getBinder().bind(personName, PersonDTO::getName, (PersonDTO p, String n) -> {
            p.setName(n);
            personClient.createOrUpdateJson(p);
        }));
        personsGrid.removeColumn("favourites");
        personsGrid.addColumn(s -> "Delete", new ButtonRenderer<>(e -> {
            try {
                personClient.delete(e.getItem().getId());
                persons.remove(e.getItem());
                personsGrid.setItems(persons);
            } catch (SeriesServiceException ex) {
                Notification.show("Cannot delete this person", Notification.Type.WARNING_MESSAGE);
            }
        }));
        personsGrid.getEditor().setEnabled(true);
        personsGrid.setItems(persons);

        Grid<SerieDTO> favouritesGrid = new Grid<>();
        favouritesGrid.addColumn(SerieDTO::getEditorId).setCaption("Editor ID");
        favouritesGrid.addColumn(SerieDTO::getTitle).setCaption("Title");
        favouritesGrid.addColumn(s -> "Remove from favourites", new ButtonRenderer<>(e -> {
            PersonDTO selPerson = personsGrid.getSelectedItems().stream().findFirst().get();
            personClient.removeFavouriteJson(selPerson.getId(), e.getItem().getTitle(), e.getItem().getEditorId());
            selPerson.getFavourites().remove(e.getItem());
            favouritesGrid.setItems(selPerson.getFavourites());
        }));

        personsGrid.addSelectionListener(event -> {
            Optional<PersonDTO> selected = event.getFirstSelectedItem();
            if (selected.isPresent()) {
                favouritesGrid.setItems(selected.get().getFavourites());
            } else {
                favouritesGrid.setItems(new ArrayList<>());
            }
        });

        Button addToFavouritesButton = new Button("Add to favourites", e -> {
            PersonDTO selPerson = personsGrid.getSelectedItems().stream().findFirst().get();
            SerieDTO selSerie = seriesGrid.getSelectedItems().stream().findFirst().get();
            try {
                personClient.addFavouriteJson(selPerson.getId(), selSerie.getTitle(), selSerie.getEditorId());
                selPerson.getFavourites().add(selSerie);
                favouritesGrid.setItems(selPerson.getFavourites());
            } catch (SeriesServiceException ex) {
                Notification.show("Cannot add this favourite", Notification.Type.WARNING_MESSAGE);
            }
        });
        addToFavouritesButton.setEnabled(false);
        SelectionListener l = e -> addToFavouritesButton.setEnabled(seriesGrid.getSelectedItems().size() > 0 && personsGrid.getSelectedItems().size() > 0);
        seriesGrid.addSelectionListener(l);
        personsGrid.addSelectionListener(l);

        HorizontalLayout personsLayout = new HorizontalLayout(personsGrid, addToFavouritesButton, favouritesGrid);

        Label addPersonHead = new Label("Add person");
        TextField nameField = new TextField("Name");
        final Binder<PersonDTO> personBinder = new Binder<>(PersonDTO.class);
        personBinder.forField(nameField).asRequired().bind("name");
        Button submitPerson = new Button("Add person", e -> {
            PersonDTO pdto = new PersonDTO();
            if (personBinder.writeBeanIfValid(pdto)) {
                personClient.createOrUpdateJson(pdto);
                persons.add(pdto);
                personsGrid.setItems(persons);
            }
        });

        layout.addComponents(personsHead, personsLayout, addPersonHead, nameField, submitPerson);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "SeriesUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = SeriesUI.class, productionMode = false)
    public static class SeriesUIServlet extends VaadinServlet {
    }
}
