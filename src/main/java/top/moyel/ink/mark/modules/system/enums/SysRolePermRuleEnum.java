package top.moyel.ink.mark.modules.system.enums;

import com.mybatisflex.annotation.EnumValue;

/**
 * 系统 角色权限规则枚举
 *
 * @author moyel
 */
public enum SysRolePermRuleEnum {
    ALL(0),
    ADDITIONAL(1),
    SUBTRACTION(2);

    SysRolePermRuleEnum(int code) {
        this.code = code;
    }

    @EnumValue
    private final int code;

    @SuppressWarnings("unused")
    public int getCode() {
        return code;
    }
}
