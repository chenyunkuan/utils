package cn.ykchen.utils.web.response;

/**
 * Created by yk.chen on 2017/4/13.
 */
public class ResponseVO<T> {

    protected int code;
    protected String result;
    protected T body;

    public ResponseVO(){

    }

    public ResponseVO(int code, String result, T body){
        this.code = code ;
        this.result = result;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
