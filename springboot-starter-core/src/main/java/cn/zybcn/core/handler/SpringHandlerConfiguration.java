package cn.zybcn.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 22:04
 */
@Configuration
public class SpringHandlerConfiguration {


    @Bean
    public SpringEventHandler springEventHandler(@Autowired(required = false) List<IHandler> handlers) {
        ExecutorService executorService =
                new ThreadPoolExecutor
                        (10, 2, 3, TimeUnit.MINUTES,
                                new LinkedBlockingQueue<Runnable>(100),
                                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        return new SpringEventHandler(handlers, executorService);
    }
}
