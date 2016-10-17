package kelner.views;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
            stage.setScene(new Scene(root));

            commandField = (TextField) root.lookup("#command_field");
            if (commandField == null) {
                throw new Exception("Missing command field");
            }

            submitButton = (Button) root.lookup("#submit_button");
            if (commandField == null) {
                throw new Exception("Missing submit button");
            }

            errorLabel = (Text) root.lookup("#error_label");
            if (errorLabel == null) {
                throw new Exception("Missing error label");
            }

            historyListView = (ListView) root.lookup("#history_listview");
            if (historyListView == null) {
                throw new Exception("Missing history ListView");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void render() {
        if (!isRendered) {
            stage.show();
            isRendered = true;
        }
    }

}
