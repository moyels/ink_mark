package top.moyel.ink.mark.modules.system.rest;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.ink.mark.modules.system.entity.SysRole;
import top.moyel.ink.mark.modules.system.mapstruct.SysRoleMapStruct;
import top.moyel.ink.mark.modules.system.service.ISysRoleService;
import top.moyel.ink.mark.modules.system.validate.SysRoleSaveValidate;
import top.moyel.ink.mark.modules.system.validate.SysRoleUpdateValidate;
import top.moyel.ink.mark.modules.system.vo.SysRoleFormVO;

import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/role")
public class SysRoleRest {
    private final ISysRoleService sysRoleService;

    @GetMapping
    public Page<SysRole> pageRoles(
            @RequestParam(defaultValue = "1")
            Integer page,
            @RequestParam(defaultValue = "10")
            Integer size
    ) {
        return sysRoleService.page(page, size, new QueryWrapper());
    }

    @PostMapping
    public Boolean saveRole(
            @RequestBody
            @Validated(value = {Default.class, SysRoleSaveValidate.class})
            SysRoleFormVO sysRoleFormVO
    ) {
        return sysRoleService.save(SysRoleMapStruct.INSTANCE.toDO(sysRoleFormVO));
    }

    @PutMapping
    public Boolean updateRole(
            @RequestBody
            @Validated(value = {Default.class, SysRoleUpdateValidate.class})
            SysRoleFormVO sysRoleFormVO
    ) {
        return sysRoleService.save(SysRoleMapStruct.INSTANCE.toDO(sysRoleFormVO));
    }

    @DeleteMapping
    public Boolean removeRoles(@NotEmpty List<Long> ids) {
        return sysRoleService.removeBatch(ids);
    }
}
