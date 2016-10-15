package kelner.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import kelner.models.validators.FreeTableValidator;
import kelner.views.GameView;

public class GameController extends Application {

    private GameView gameView;


    public static void main(String... args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        gameView = new GameView(primaryStage);
        gameView.render();
    }


    public void actionAddNewClient(ActionEvent event) {

        if (FreeTableValidator.validate()) {
            // find free table and assign to new ppl
        }

    }

}
