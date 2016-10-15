package kelner.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView {

    private Stage stage;

    public GameView(Stage primaryStage) {

        stage = primaryStage;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("xml/game_ui.fxml"));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void render() {
        stage.show();
    }

}
