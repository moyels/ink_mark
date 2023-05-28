package top.moyel.ink.mark.modules.system.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.ink.mark.modules.system.entity.SysRole;
import top.moyel.ink.mark.modules.system.service.ISysRolePermService;
import top.moyel.ink.mark.modules.system.service.ISysRoleService;
import top.moyel.ink.mark.modules.system.utils.SysRoleUtil;

import java.util.List;

/**
 * @author moyel
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/role/perm")
public class SysRolePermRest {
    private final ISysRolePermService sysRolePermService;
    private final ISysRoleService sysRoleService;

    @GetMapping
    public List<Long> getRolePerms(Long roleId) {
        List<SysRole> roleList = sysRoleService.list();
        return SysRoleUtil.getParentRoleIds(roleList, roleId);
    }
}
