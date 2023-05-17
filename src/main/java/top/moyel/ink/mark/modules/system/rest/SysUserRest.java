package top.moyel.ink.mark.modules.system.rest;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.ink.mark.config.project.InkMarkProps;
import top.moyel.ink.mark.modules.system.entity.SysUser;
import top.moyel.ink.mark.modules.system.qo.SysUserQueryVO;
import top.moyel.ink.mark.modules.system.service.ISysUserService;
import top.moyel.ink.mark.modules.system.validate.SysUserPutGroup;
import top.moyel.ink.mark.modules.system.vo.SysUserFormVO;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user")
public class SysUserRest {
    private final InkMarkProps inkMarkProps;

    private final ISysUserService sysUserService;

    @GetMapping
    public Page<SysUser> page(Integer page, Integer size, SysUserQueryVO sysUserQueryVO) {
        return sysUserService.page(page, size, sysUserQueryVO.createWrapper());
    }

    @PostMapping
    public Boolean save(@Valid @RequestBody SysUserFormVO sysUserFormVO) {
        String salt = IdUtil.nanoId(6);
        String realPassword = StrUtil.firstNonBlank(sysUserFormVO.getPassword(), inkMarkProps.getDefaultPassword());

        String saltPassword = SaSecureUtil.md5BySalt(realPassword, salt);

        SysUser sysUser = new SysUser();
        sysUser.setUsername(sysUserFormVO.getUsername());
        sysUser.setPassword(saltPassword);
        sysUser.setSalt(salt);
        sysUser.setNickname(sysUserFormVO.getNickname());

        return sysUserService.save(sysUser);
    }

    @DeleteMapping
    public Boolean remove(Long id) {
        return sysUserService.remove(id);
    }

    @PutMapping
    public Boolean update(@Validated(SysUserPutGroup.class) @RequestBody SysUser sysUser) {
        SysUser storedSysUser = sysUserService.fetch(sysUser.getId());
        if (Objects.isNull(storedSysUser)) {
            return false;
        }

        return sysUserService.update(sysUser);
    }
}
