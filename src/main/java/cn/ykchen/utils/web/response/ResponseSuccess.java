package cn.ykchen.utils.web.response;

/**
 * Created by yk.chen on 2017/4/13.
 */
public class ResponseSuccess<T> extends ResponseVO<T> {

    private static final String SCCESS_MSG = "成功";

    private static final int SCCESS_CODE = 1;

    public ResponseSuccess() {
        super(SCCESS_CODE, SCCESS_MSG, null);
    }

    public ResponseSuccess(T body) {
        super(SCCESS_CODE, SCCESS_MSG, body);
    }
}
