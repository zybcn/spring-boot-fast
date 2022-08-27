package cn.zybcn.core.dto.response;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 20:17
 */
public class SingleResponse<T> extends Response {


    private T data;

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> singleResponse = new SingleResponse<>();
        singleResponse.setSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
