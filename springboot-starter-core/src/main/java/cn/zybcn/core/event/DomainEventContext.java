package cn.zybcn.core.event;

import org.springframework.context.ApplicationContext;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 21:04
 */
public class DomainEventContext {

    private static volatile DomainEventContext instance;

    private ApplicationContext context;

    private DomainEventContext() {

    }

    protected void initContext(ApplicationContext context) {
        this.context = context;
    }

    public static DomainEventContext getInstance() {
        if (instance == null) {
            synchronized (DomainEventContext.class) {
                if (instance == null) {
                    instance = new DomainEventContext();
                }
            }
        }
        return instance;
    }


    /**
     * @param event 默认 同步事件
     */
    public void push(IEvent event) {
        if (event instanceof IAsyncEvent) {
            this.push(event, false);
        } else if (event instanceof ISyncEvent) {
            this.push(event, true);
        } else {
            this.push(event, true);
        }
    }

    private void push(IEvent event, boolean sync) {
        if (context != null) {
            context.publishEvent(new DomainEvent(event, sync));
        }
    }

}
