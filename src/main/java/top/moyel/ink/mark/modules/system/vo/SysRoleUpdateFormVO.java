package top.moyel.ink.mark.modules.system.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysRoleUpdateFormVO {
    @NotNull
    private Long id;
    @NotBlank
    private String roleName;
    @NotBlank
    private String roleCode;
    private Long parentRole;
    @NotNull
    private Integer sortNo;
}
