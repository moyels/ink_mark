package top.moyel.ink.mark.base.entity;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ModifierUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import top.moyel.ink.mark.anno.QueryParam;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BaseQueryVO {
    /**
     * 创建查询条件
     *
     * @return 查询条件
     */
    public QueryWrapper createWrapper() {
        QueryWrapper wrapper = QueryWrapper.create();
        List<QueryParamEntity> queryParamEntities = scanFields();
        queryParamEntities.forEach(queryParamEntity -> wrapper.and(createCondition(queryParamEntity.getQueryParam(), queryParamEntity.getField().getName(), queryParamEntity.getVal())));
        return wrapper;
    }

    /**
     * 扫描字段，生成查询参数实体列表
     *
     * @return 查询参数实体列表
     */
    private List<QueryParamEntity> scanFields() {
        Field[] fields = ReflectUtil.getFieldsDirectly(this.getClass(), false);
        BaseQueryVO val = this;
        return Arrays.stream(fields).filter(field -> !ModifierUtil.isStatic(field))
                .map(field -> {
                    field.setAccessible(true);

                    if (!AnnotationUtil.hasAnnotation(field, QueryParam.class)) {
                        return null;
                    }

                    QueryParam queryParam = AnnotationUtil.getAnnotation(field, QueryParam.class);
                    Object fieldValue = ReflectUtil.getFieldValue(val, field);
                    return new QueryParamEntity(queryParam, field, fieldValue);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 生成查询条件
     *
     * @param queryParam 查询参数实体
     * @param fieldName  字段名
     * @param val        数值
     * @return 查询条件
     */
    private QueryCondition createCondition(QueryParam queryParam, String fieldName, Object val) {
        if (queryParam.ignoreNull() && Objects.isNull(val)) {
            return null;
        }

        if ((val instanceof String) && queryParam.ignoreBlank() && StrUtil.isBlank(((String) val))) {
            return null;
        }

        String columnName = StrUtil.firstNonBlank(queryParam.value(), StrUtil.toUnderlineCase(fieldName));
        return QueryCondition.create(new QueryColumn(columnName), queryParam.logic(), val);
    }
}
