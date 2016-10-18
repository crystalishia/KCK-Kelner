package kelner.components;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract public class DictionaryLoader {

    private static final String ACTION_FILE_PATH = "src/kelner/components/dictionaries/actions.txt";

    private static List<ActionRow> cachedActionsRows = null;

    public static List<ActionRow> getActionsRows() throws UserException {

        if (cachedActionsRows == null) {

            cachedActionsRows = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(ACTION_FILE_PATH));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] elements = line.split(" ");

                    try {
                        cachedActionsRows.add(new ActionRow(elements[0], Integer.valueOf(elements[1])));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                }

            } catch (IOException e) {
                throw new UserException("File actions.txt not found");
            }
        }

        return cachedActionsRows;
    }


}
