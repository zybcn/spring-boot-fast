package cn.zybcn.core.dto.response;

import java.util.Collection;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 20:18
 */
public class MultiResponse<T> extends Response {
    private long total;

    private Collection<T> data;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }


    public static <T> MultiResponse<T> of(Collection<T> data, long total) {
        MultiResponse<T> multiResponse = new MultiResponse<>();
        multiResponse.setSuccess(true);
        multiResponse.setData(data);
        multiResponse.setTotal(total);
        return multiResponse;
    }


    public static <T> MultiResponse<T> of(Collection<T> data) {
        MultiResponse<T> multiResponse = new MultiResponse<>();
        multiResponse.setSuccess(true);
        multiResponse.setData(data);
        long total = 0;
        if (data != null) {
            total = data.size();
        }
        multiResponse.setTotal(total);
        return multiResponse;
    }


}
