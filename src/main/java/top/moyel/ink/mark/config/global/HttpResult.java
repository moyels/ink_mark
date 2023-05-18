package top.moyel.ink.mark.config.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.moyel.ink.mark.consts.HttpResultConsts;

/**
 * @author moyel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T data;
    private Long timestamp;

    public static <T> HttpResult<T> ok(T data) {
        return ok(data, HttpResultConsts.SUCCESS_MSG);
    }

    public static <T> HttpResult<T> ok(T data, String message) {
        return new HttpResult<>(true, HttpResultConsts.SUCCESS_CODE, message, data, System.currentTimeMillis());
    }

    public static <T> HttpResult<T> fail() {
        return fail(HttpResultConsts.FAILURE_MSG);
    }

    public static <T> HttpResult<T> fail(String message) {
        return new HttpResult<>(false, HttpResultConsts.FAILURE_CODE, message, null, System.currentTimeMillis());
    }
}
