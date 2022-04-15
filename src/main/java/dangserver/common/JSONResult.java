package dangserver.common;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class JSONResult<T> {
    private boolean flag;
    private String msg;
    private T data;

    // 请求成功
    public JSONResult(T data) {
        this.flag = true;
        this.msg = "Success";
        this.data = data;
    }

    // 请求失败
    public JSONResult(boolean flag, String msg) {
        this.flag = false;
        this.msg = msg;
        this.data = null;
    }
}
