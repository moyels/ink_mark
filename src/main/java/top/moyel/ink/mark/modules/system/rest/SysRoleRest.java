package top.moyel.ink.mark.modules.system.rest;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.ink.mark.modules.system.entity.SysRole;
import top.moyel.ink.mark.modules.system.service.ISysRoleService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/role")
public class SysRoleRest {
    private final ISysRoleService sysRoleService;

    @GetMapping
    public Page<SysRole> pageRoles(Integer page, Integer size) {
        return sysRoleService.page(page, size, new QueryWrapper());
    }
}
