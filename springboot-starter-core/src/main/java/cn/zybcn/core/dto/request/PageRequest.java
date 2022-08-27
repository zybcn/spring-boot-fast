package cn.zybcn.core.dto.request;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 20:20
 */
public class PageRequest {

    private int current;
    private int pageSize;

    public PageRequest(int current, int pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
