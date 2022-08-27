package cn.zybcn.core.event;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 21:05
 * @Desc event推送助手
 */
public class EventPusher {

    public static void push(IEvent event) {
        DomainEventContext.getInstance().push(event);
    }
}
