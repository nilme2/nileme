package me.nilme.exercise.java.action;


/**
 * @author taoshanchang 15/11/4
 */
public abstract class AbstractAction implements Action {

    private String actionName;

    @Override
    public String getActionName() {
        if (actionName == null) {
            return this.getClass().getSimpleName();
        }
        return actionName;
    }

    public AbstractAction() {
    }

    public AbstractAction(String actionName) {
        this.actionName = actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public abstract boolean doAction(Event event) throws Exception;

    @Override
    public abstract void doFailure(Event event) throws Exception;
}
