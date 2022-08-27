package cn.zybcn.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 20:28
 */
public class DomainEvent extends ApplicationEvent {

    private IEvent event;
    /**
     * 同步或异步事件
     * true 同步
     * false 异步
     */

    private boolean sync;

    public DomainEvent(Object source, boolean sync) {
        super(source);
        this.event = (IEvent) source;
        this.sync = sync;
    }

    public IEvent getEvent() {
        return event;
    }

    public void setEvent(IEvent event) {
        this.event = event;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }
}
