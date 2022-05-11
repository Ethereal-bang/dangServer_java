package dangserver.common;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
public class JSONResult {

    private boolean flag;

    private String msg;

    private Map<String, Object> data = new HashMap<>();

    private Object singleData;

    private JSONResult() {}

    // 请求成功
    public static JSONResult ok() {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setFlag(true);
        jsonResult.setMsg("查询成功");
        return jsonResult;
    }

    public static JSONResult ok(Object singleData) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setFlag(true);
        jsonResult.setMsg("查询成功");
        jsonResult.setSingleData(singleData);
        return jsonResult;
    }

    // 请求失败
    public static JSONResult err() {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setFlag(false);
        jsonResult.setMsg("查询失败");
        return jsonResult;
    }

    // 成功并返回数据(key-value)
    public JSONResult data(String key, Object val) {
        this.data.put(key, val);
        return this;
    }

    public JSONResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
