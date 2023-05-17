package top.moyel.ink.mark.modules.system.vo;

import lombok.Data;
import top.moyel.ink.mark.modules.system.validate.SysRoleSaveValidate;
import top.moyel.ink.mark.modules.system.validate.SysRoleUpdateValidate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class SysRoleFormVO {
    @Null(groups = SysRoleSaveValidate.class)
    @NotNull(groups = SysRoleUpdateValidate.class)
    private Long id;
    @NotBlank
    private String roleName;
    @NotBlank
    private String roleCode;
    private Long parentRole;
    @NotNull
    private Integer sortNo;
}
