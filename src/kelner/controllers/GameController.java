package kelner.controllers;

import javafx.application.Application;
import javafx.stage.Stage;
import kelner.models.HistoryLogger;
import kelner.models.Parser;
import kelner.views.GameView;

public class GameController extends Application {

    private GameView gameView;


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            gameView = new GameView(primaryStage);
            gameView.render();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        gameView.setUpSubmitClickListener(event -> actionOnSubmitClick());
        HistoryLogger.init(gameView.getHistoryListView());

    }

    private void actionOnSubmitClick() {

        String text = gameView.getCommandField().getText();

        if (text.isEmpty()) {
            gameView.setErrorText("Command is empty");
        } else {
            gameView.clearErrorField();

            Parser parser = new Parser(text);

        }

    }

}
