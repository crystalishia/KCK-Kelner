package kelner.components;

public class ActionRow {

    public final String word;
    public final int actionId;

    public ActionRow(String word, int actionId) {
        this.word = word;
        this.actionId = actionId;
    }

    @Override
    public String toString() {
        return "ActionRow{word=" + word + ", actionId=" + actionId + "}";
    }


    public boolean contains(String[] words) {

        for (String word : words) {
            if (this.word.equals(word)) return true;
        }

        return false;
    }
}
