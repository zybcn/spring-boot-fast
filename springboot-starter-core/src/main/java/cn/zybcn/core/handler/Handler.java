package cn.zybcn.core.handler;

import java.lang.annotation.*;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 23:16
 * @Desc handler bean注解
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Handler {
}
