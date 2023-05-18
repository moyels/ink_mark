package top.moyel.ink.mark.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.moyel.ink.mark.anno.QueryParam;

import java.lang.reflect.Field;

/**
 * @author moyel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryParamEntity {
    private QueryParam queryParam;
    private Field field;
    private Object val;
}
