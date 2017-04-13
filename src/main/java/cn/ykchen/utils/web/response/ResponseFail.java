package cn.ykchen.utils.web.response;

/**
 * Created by yk.chen on 2017/4/13.
 */
public class ResponseFail<T> extends ResponseVO<T> {

    private static final String FAIL_MSG = "成功";

    private static final int FAIL_CODE = 1;

    public ResponseFail() {
        super(FAIL_CODE, FAIL_MSG, null);
    }

    public ResponseFail(int code,String result) {
        super(code, result, null);
    }
}
