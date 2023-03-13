package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of scores.
 */

public class ScoreListPanel extends UiPart<Region> {
    private static final String FXML = "ScoreListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ScoreListPanel.class);
    private final NumberAxis xAxis = new NumberAxis();
    private final NumberAxis yAxis = new NumberAxis();

    @FXML
    private ListView<Person> scoreListView;
    @FXML
    private LineChart<Number, Number> scoreChart;

    /**
     * Creates a {@code ScoreListPanel} with the given {@code ObservableList}.
     */
    public ScoreListPanel(ObservableList<Person> scoreList) {
        super(FXML);
        scoreListView.setItems(scoreList);
        scoreListView.setCellFactory(listView -> new ScoreListPanel.ScoreListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Score} using a {@code ScoreCard}.
     */
    class ScoreListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person score, boolean empty) {
            super.updateItem(score, empty);

            if (empty || score == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ScoreCard(score, getIndex() + 1).getRoot());
            }
        }
    }
}
