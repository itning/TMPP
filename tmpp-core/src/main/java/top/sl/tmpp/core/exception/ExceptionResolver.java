package top.sl.tmpp.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sl.tmpp.common.exception.BaseException;
import top.sl.tmpp.common.util.RestModel;

import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理
 *
 * @author Ning
 */
@ControllerAdvice
public class ExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    /**
     * json 格式错误消息
     *
     * @param response HttpServletResponse
     * @param e        Exception
     * @return 异常消息
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestModel jsonErrorHandler(HttpServletResponse response, Exception e) {
        logger.error("jsonErrorHandler->{}:{} {}", e.getClass().getSimpleName(), e.getMessage(), e);
        RestModel restModel = new RestModel();
        restModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        restModel.setMsg(e.getMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return restModel;
    }

    /**
     * BaseException 错误
     *
     * @param response HttpServletResponse
     * @param e        BaseException
     * @return 异常消息
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public RestModel baseErrorHandler(HttpServletResponse response, BaseException e) {
        logger.info("baseErrorHandler->{}:{}", e.getClass().getSimpleName(), e.getMessage());
        RestModel restModel = new RestModel();
        restModel.setCode(e.getCode().value());
        restModel.setMsg(e.getMessage());
        response.setStatus(e.getCode().value());
        return restModel;
    }
}
