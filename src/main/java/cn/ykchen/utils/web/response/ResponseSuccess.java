package cn.ykchen.utils.web.response;

/**
 * Created by yk.chen on 2017/4/13.
 */
public class ResponseSuccess<T> extends ResponseVO<T> {

    private static final String SUCCESS_MSG = "成功";

    private static final int SUCCESS_CODE = 1;

    public ResponseSuccess() {
        super(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public ResponseSuccess(T body) {
        super(SUCCESS_CODE, SUCCESS_MSG, body);
    }
}
