package top.moyel.ink.mark.modules.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.moyel.ink.mark.anno.QueryParam;
import top.moyel.ink.mark.base.entity.BaseQueryVO;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginFormVO extends BaseQueryVO {
    @NotBlank
    @QueryParam(ignoreBlank = true)
    private String username;
    @NotBlank
    private String password;
    private String captcha;
}
