package top.moyel.ink.mark.modules.system.rest;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.ink.mark.modules.system.entity.SysUser;
import top.moyel.ink.mark.modules.system.service.ISysUserService;
import top.moyel.ink.mark.modules.system.vo.LoginFormVO;

import javax.validation.Valid;
import java.util.List;

/**
 * @author moyel
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginRest {
    private final ISysUserService sysUserService;

    /**
     * 登录接口
     *
     * @param loginFormVO 登录表单
     * @return 登录是否成功
     * @folder 登录
     */
    @PostMapping("/login")
    public Boolean login(@Valid @RequestBody LoginFormVO loginFormVO) {
        List<SysUser> sysUserList = sysUserService.list(loginFormVO.createWrapper());

        if (CollectionUtil.isEmpty(sysUserList) || CollectionUtil.size(sysUserList) != 1) {
            return false;
        }

        SysUser sysUser = CollectionUtil.getFirst(sysUserList);
        String viewCalcMd5 = SaSecureUtil.md5BySalt(loginFormVO.getPassword(), sysUser.getSalt());

        if (!StrUtil.equals(viewCalcMd5, sysUser.getPassword())) {
            return false;
        }

        StpUtil.login(sysUser.getId());

        return true;
    }
}
