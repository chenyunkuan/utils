package cn.ykchen.utils.web;


import cn.ykchen.utils.web.response.ResponseFail;
import cn.ykchen.utils.web.response.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yk.chen on 2017/4/12.
 * 统一的异常处理
 */
@ControllerAdvice
public class SpringExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVO handleException(RuntimeException exception){
        logger.error(exception.getMessage(),exception);
        return  new ResponseFail(0,exception.getMessage());
    }


}
