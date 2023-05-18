package top.moyel.ink.mark.config.global;

import lombok.NonNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.moyel.ink.mark.anno.DisableHttpResult;

import java.util.Objects;

/**
 * @author moyel
 */
@RestControllerAdvice
public class RestControllerInterceptor implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        if (Objects.isNull(returnType.getMethod()) || void.class.equals(returnType.getMethod().getReturnType()) || HttpResult.class.equals(returnType.getMethod().getReturnType())) {
            return false;
        }

        return !returnType.getContainingClass().isAnnotationPresent(DisableHttpResult.class) && !returnType.hasMethodAnnotation(DisableHttpResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        if (Objects.isNull(body)) {
            return HttpResult.fail();
        }

        if (body instanceof Boolean) {
            if (((Boolean) body)) {
                return HttpResult.ok(true);
            }

            return HttpResult.fail();
        }

        return HttpResult.ok(body);
    }
}
