package kelner.controllers;

import javafx.application.Application;
import javafx.stage.Stage;
import kelner.components.UserException;
import kelner.models.Action;
import kelner.models.HistoryLogger;
import kelner.models.Parser;
import kelner.views.GameView;

public class GameController extends Application {

    private GameView gameView;


    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            UserException.init(primaryStage);
            gameView = new GameView(primaryStage);
            gameView.render();
        } catch (UserException e) {
            e.handleException();
            return;
        }

        gameView.setUpSubmitClickListener(event -> actionOnSubmitClick());
        HistoryLogger.init(gameView.getHistoryListView());
    }

    private void actionOnSubmitClick() {

        String command = gameView.getCommandField().getText();

        if (command.isEmpty()) {
            gameView.setErrorText("Command is empty");
        } else {
            gameView.clearCommandField();
            gameView.clearErrorField();
            Parser parser = new Parser(command);
            HistoryLogger.log("Client: " + parser.getOriginalText());

            try {
                Action action = parser.findActionByKeyWords();
            } catch (UserException e) {
                e.handleException();
            }

        }

    }

}
