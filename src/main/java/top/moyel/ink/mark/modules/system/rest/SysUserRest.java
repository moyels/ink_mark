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

/**
 * @author moyel
 * @folder 系统管理/用户管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user")
public class SysUserRest {
    private final InkMarkProps inkMarkProps;

    private final ISysUserService sysUserService;

    /**
     * 分页获取用户信息
     *
     * @param page           页码
     * @param size           每页条数
     * @param sysUserQueryVO 用户查询条件
     * @return 用户分页实例
     */
    @GetMapping
    public Page<SysUser> page(Integer page, Integer size, SysUserQueryVO sysUserQueryVO) {
        return sysUserService.page(page, size, sysUserQueryVO.createWrapper());
    }

    /**
     * 新增用户
     *
     * @param sysUserFormVO 新增用户表单信息
     * @return 是否成功
     */
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

    /**
     * 移除用户
     *
     * @param id 用户id
     * @return 是否成功
     */
    @DeleteMapping
    public Boolean remove(Long id) {
        return sysUserService.remove(id);
    }

    /**
     * 更新用户信息
     *
     * @param sysUser 用户信息
     * @return 是否更新成功
     */
    @PutMapping
    public Boolean update(@Validated(SysUserPutGroup.class) @RequestBody SysUser sysUser) {
        SysUser storedSysUser = sysUserService.fetch(sysUser.getId());
        if (Objects.isNull(storedSysUser)) {
            return false;
        }

        return sysUserService.update(sysUser);
    }
}
