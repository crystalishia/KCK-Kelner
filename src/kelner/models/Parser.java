package kelner.models;

public class Parser {

    private String fullText;

    public Parser(String text) {
        fullText = text;
        prepareString();
    }

    private void prepareString() {
        fullText = fullText
                .trim()
                .replaceAll("\\s+", " ")
                .toLowerCase();
    }

    public String getFullText() {
        return fullText;
    }

}
