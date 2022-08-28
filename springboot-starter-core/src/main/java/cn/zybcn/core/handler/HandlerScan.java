package cn.zybcn.core.handler;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-28 12:13
 */
public @interface HandlerScan {


    /**
     * 用于设置扫描的包
     */
    String[] scanPackage();
}
