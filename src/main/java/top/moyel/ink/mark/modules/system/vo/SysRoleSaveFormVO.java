package top.moyel.ink.mark.modules.system.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author moyel
 */
@Data
public class SysRoleSaveFormVO {
    @NotBlank
    private String roleName;
    @NotBlank
    private String roleCode;
    private Long parentRole;
    @NotNull
    private Integer sortNo;
}
