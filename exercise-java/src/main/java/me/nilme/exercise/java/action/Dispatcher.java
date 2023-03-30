package me.nilme.exercise.java.action;

import lombok.extern.slf4j.Slf4j;
import me.nilme.exercise.java.action.exception.ActionNullException;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * action核心事件处理器,控制着事件的执行流程,接受一个action链作为真正的事件执行者,\
 * 支持传入web容器的HttpServletRequest与HttpServletResponse,进行web相关操作
 *
 * @author taoshanchang 15/11/4
 */
@Slf4j
public class Dispatcher {

    private ActionChain actionChain;

    private int actionIndex = 0;

    /**
     * 构造器,必须传入一个action链
     */
    public Dispatcher(ActionChain actionChain) {
        this.actionChain = actionChain;
    }

    /**
     * 拦截器,接受一个事件,并按顺序执行链中action的doAction方法
     *
     * @param event 事件
     */
    public void doDispatch(Event event) {
        List<Action> actions = actionChain.getActions();

        if (CollectionUtils.isEmpty(actions)) {
            throw new ActionNullException("动作为空");
        }

        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            try {
                boolean result = action.doAction(event);
                if (!result) {
                    log.info(action.getActionName() + "执行失败");
                    triggerFailure(event);
                    return;
                }
                log.info(action.getActionName() + "执行成功");
            } catch (Exception e) {
                log.info(action.getActionName() + "执行失败");
                triggerFailure(event);
            }
            actionIndex = i;
        }
    }

    /**
     * dispatcher 执行拦截器链(actionChain)的时候发生错误,会倒序执行链中被执行过的action中的doFailure方法
     *
     * @param event 执行事件
     */
    public void triggerFailure(Event event) {
        List<Action> actions = actionChain.getActions();
        try {
            for (int i = actionIndex; i >= 0; i--) {
                Action action = actions.get(i);
                try {
                    action.doFailure(event);
                } catch (Exception e) {
                    log.error("{} 执行回滚失败", action.getActionName(), e);
                }
                log.info(action.getActionName() + "执行回滚完成");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    public ActionChain getActionChain() {
        return actionChain;
    }

    public void setActionChain(ActionChain actionChain) {
        this.actionChain = actionChain;
    }


}
