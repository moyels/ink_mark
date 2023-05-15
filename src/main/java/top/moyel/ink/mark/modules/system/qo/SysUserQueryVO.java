package top.moyel.ink.mark.modules.system.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.moyel.ink.mark.anno.QueryParam;
import top.moyel.ink.mark.base.entity.BaseQueryVO;

/**
 * @author moyel
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserQueryVO extends BaseQueryVO {
    @QueryParam(ignoreBlank = true)
    private String username;
}
