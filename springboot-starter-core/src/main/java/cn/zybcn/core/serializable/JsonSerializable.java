package cn.zybcn.core.serializable;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 20:09
 */
public interface JsonSerializable extends Serializable {


    /**
     * @return 将对象序列化为json
     */
    default String toJson() {
        return JSONObject.toJSONString(this);
    }
}
