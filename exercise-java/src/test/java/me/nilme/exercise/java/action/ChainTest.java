package me.nilme.exercise.java.action;

/**
 * Created by nil on 2021/11/27.
 */
public class ChainTest {

    public static void main(String[] args) {
        ActionChain actionChain = new ActionChain();

        Action1 action1 = new Action1();
        Action2 action2 = new Action2();
        Action3 action3 = new Action3();

        actionChain.addAction(action1);
        actionChain.addAction(action2);
        actionChain.addAction(action3);

        Dispatcher dispatcher = new Dispatcher(actionChain);

        Event event = new Event();
        dispatcher.doDispatch(event);

    }
}
