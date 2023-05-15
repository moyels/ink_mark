package top.moyel.ink.mark.modules.system.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class SysUserFormVO {
    @NotEmpty
    @Length(min = 6, max = 200)
    private String username;
    private String nickname;
    private String password;
}
