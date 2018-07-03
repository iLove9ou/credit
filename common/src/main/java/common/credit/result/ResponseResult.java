package common.credit.result;


public class ResponseResult {

    //返回码
    private String code;

    //信息描述
    private String message;

    //业务对象
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(String code, String message) {
        setCode(code);
        setMessage(message);
        setData(null);
    }
    public ResponseResult(String code, String message, Object data) {
        setCode(code);
        setMessage(message);
        setData(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
