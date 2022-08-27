package cn.zybcn.core.handler;

import cn.zybcn.core.event.DomainEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 21:57
 */
public class SpringEventHandler implements ApplicationListener<DomainEvent> {


    private ExecutorService executorService;

    public SpringEventHandler(List<IHandler> handlers, ExecutorService executorService) {
        ApplicationHandlerUtils.getInstance().addHandlers(handlers);
        this.executorService = executorService;
    }

    @Override
    public void onApplicationEvent(DomainEvent domainEvent) {
        if (domainEvent.isSync()) {
            ApplicationHandlerUtils.getInstance().handler(domainEvent.getEvent());
        } else {
            executorService.execute(() -> {
                ApplicationHandlerUtils.getInstance().handler(domainEvent.getEvent());
            });
        }
    }
}
