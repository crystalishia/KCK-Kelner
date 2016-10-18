package kelner.models;

import kelner.components.ActionRow;
import kelner.components.DictionaryLoader;
import kelner.components.UserException;

import java.util.List;

public class Parser {

    private final String fullText;
    private final String originalText;
    private String[] parts;

    public Parser(String text) {
        originalText = text;
        fullText = prepareString(text);
        parts = fullText.split(" ");
    }

    private String prepareString(String text) {
        return text
                .trim()
                .replaceAll("\\s+", " ")
                .toLowerCase();
    }

    public String getFullText() {
        return fullText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public Action findActionByKeyWords() throws UserException {

        List<ActionRow> actionsRows = DictionaryLoader.getActionsRows();
        System.out.println(actionsRows);
        Integer id = null;

        for (ActionRow actionRow : actionsRows) {
            if (actionRow.contains(parts)) {
                id = actionRow.actionId;
            }
        }

        if (id == null) {
            throw new UserException("No action recognized");
        }

        return Action.findById(id);
    }


}
