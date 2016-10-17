package kelner.views;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kelner.components.UserException;

import java.io.IOException;

public class GameView {

    private boolean isRendered = false;

    private Stage stage;
    private TextField commandField;
    private Button submitButton;
    private Text errorLabel;
    private ListView historyListView;

    public GameView(Stage primaryStage) throws Exception {

        stage = primaryStage;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("xml/game_ui.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);

            commandField = (TextField) findById(root, "command_field", true);
            submitButton = (Button) findById(root, "submit_button", true);
            errorLabel = (Text) findById(root, "error_label", true);
            historyListView = (ListView) findById(root, "history_listview", true);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Node findById(Parent root, String id, boolean throwException) throws Exception {

        for (Node node : root.getChildrenUnmodifiable()) {
            if (node.getId() != null && node.getId().equals(id)) {
                return node;
            } else if (node instanceof Parent) {
                Node parent = findById((Parent) node, id, false);
                if (parent != null) return parent;
            }
        }

        if (throwException) throw new UserException("Element with id = " + id + " not found");

        return null;
    }

    public void setUpSubmitClickListener(EventHandler<MouseEvent> event) {
        submitButton.setOnMouseClicked(event);
    }

    public TextField getCommandField() {
        return commandField;
    }

    public ListView getHistoryListView() {
        return historyListView;
    }

    public void setErrorText(String error) {
        errorLabel.setText(error);
    }

    public void clearErrorField() {
        setErrorText("");
    }

    public void clearCommandField() {
        commandField.clear();
    }

    public void render() {
        if (!isRendered) {
            stage.show();
            isRendered = true;
        }
    }

}
