package kelner.models;

import javafx.scene.control.ListView;

public class HistoryLogger {

    private static ListView<String> logField;

    public static void init(ListView<String> listView) {
        if (logField == null) {
            logField = listView;
        }
    }

    public static void log(String text) {
        int count = logField.getItems().size();
        logField.getItems().add(count, text);
    }

}
