package top.moyel.ink.mark.config.global;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionInterceptor {
    private static final String PARAMETER_ERROR = "参数存在异常！";

    @ExceptionHandler(BindException.class)
    public HttpResult<?> validateCommonExceptionHandler(BindException exception) {
        return HttpResult.fail(PARAMETER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public HttpResult<?> allExceptionHandler(Exception exception) {
        return HttpResult.fail(exception.getLocalizedMessage());
    }
}
