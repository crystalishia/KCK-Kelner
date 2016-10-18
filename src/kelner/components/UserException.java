package kelner.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserException extends Exception {

    private static Stage stage;

    public static void init(Stage stage) {
        UserException.stage = stage;
    }

    public UserException(String message) {
        super(message);
    }

    public void handleException() {

        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20));
        dialogVbox.setAlignment(Pos.CENTER);
        dialogVbox.getChildren().add(new Text(getMessage()));
        Scene dialogScene = new Scene(dialogVbox, 300, 100);

        dialog.setScene(dialogScene);
        dialog.show();

    }

}
