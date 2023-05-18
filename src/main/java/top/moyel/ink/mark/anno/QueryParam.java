package top.moyel.ink.mark.anno;

import com.mybatisflex.core.query.QueryCondition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author moyel
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryParam {
    /**
     * 列名 为空时将使用字段的 underline 格式
     *
     * @return 列名
     */
    String value() default "";

    /**
     * 计算逻辑 默认为等于逻辑
     *
     * @return 计算逻辑
     */
    String logic() default QueryCondition.LOGIC_EQUALS;

    /**
     * 过滤null
     *
     * @return 过滤空值
     */
    boolean ignoreNull() default true;

    /**
     * 过滤空字符串
     *
     * @return 过滤空字符串
     */
    boolean ignoreBlank() default false;
}
