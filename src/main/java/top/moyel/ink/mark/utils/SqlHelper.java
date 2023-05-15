package top.moyel.ink.mark.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.row.Db;
import com.mybatisflex.core.row.Row;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SqlHelper {
    public static boolean retBoolean(int retCode) {
        return retCode > 0;
    }

    public static String getTableName(Object entity) {
        Class<?> cls = entity.getClass();
        if (!cls.isAnnotationPresent(Table.class)) {
            return null;
        }

        Table tableInfo = cls.getAnnotation(Table.class);
        String tableInfoValue = tableInfo.value();

        if (StrUtil.isNotBlank(tableInfoValue)) {
            return tableInfoValue;
        }

        return tableInfo.camelToUnderline() ? StrUtil.toUnderlineCase(cls.getName()) : cls.getName();
    }

    public static boolean saveOrUpdateBatch(Collection<?> entities) {
        if (CollectionUtil.isEmpty(entities)) {
            return false;
        }

        Object entity = CollectionUtil.get(entities, 0);
        String tableName = getTableName(entity);

        List<Row> collect = entities.stream().map(SqlHelper::toRow).filter(Objects::nonNull).collect(Collectors.toList());

        return retBoolean(Db.updateBatchById(tableName, collect));
    }

    public static Row toRow(Object entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        JSONObject json = JSONUtil.parseObj(entity);

        if (CollectionUtil.isEmpty(((Map<String, Object>) json))) {
            return null;
        }

        Row row = new Row();
        row.putAll(json);
        return row;
    }
}
