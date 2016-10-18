package kelner.models;

public enum Action {

    ACTION_MAKE_ORDER(1, "Make order");

    public final String actionName;
    public final int actionId;

    Action(int actionId, String actionName) {
        this.actionName = actionName;
        this.actionId = actionId;
    }

    public static Action findById(int id) {

        for (Action action : Action.values()) {
            if (action.actionId == id) {
                return action;
            }
        }

        return null;
    }
}
