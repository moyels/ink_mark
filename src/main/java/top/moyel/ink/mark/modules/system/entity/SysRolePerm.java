package top.moyel.ink.mark.modules.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.moyel.ink.mark.base.entity.BaseEntity;
import top.moyel.ink.mark.modules.system.enums.SysRolePermRuleEnum;

/**
 * @author moyel
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRolePerm extends BaseEntity {
    private Long id;
    private Long roleId;
    private SysRolePermRuleEnum permRule;
    private String permValues;
}
