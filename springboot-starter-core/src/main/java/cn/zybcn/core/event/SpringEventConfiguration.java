package cn.zybcn.core.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 20:32
 */
@Configuration
public class SpringEventConfiguration {

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        DomainEventContext.getInstance().initContext(context);
    }


}
