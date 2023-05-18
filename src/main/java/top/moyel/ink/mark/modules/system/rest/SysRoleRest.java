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
import java.util.stream.Collectors;

/**
 * @author moyel
 * @folder 系统管理/角色管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/role")
public class SysRoleRest {
    private final ISysRoleService sysRoleService;

    /**
     * 分页获取角色
     *
     * @param page 页数
     * @param size 每页大小
     * @return 分页实例
     */
    @GetMapping
    public Page<SysRoleFormVO> pageRoles(
            @RequestParam(defaultValue = "1")
            Integer page,
            @RequestParam(defaultValue = "10")
            Integer size
    ) {
        Page<SysRole> sysRolePage = sysRoleService.page(page, size, new QueryWrapper());

        List<SysRoleFormVO> sysRoleFormVOList = sysRolePage.getRecords().stream().map(SysRoleMapStruct.INSTANCE::toVO).collect(Collectors.toList());
        return new Page<>(sysRoleFormVOList, sysRolePage.getPageNumber(), sysRolePage.getPageSize(), sysRolePage.getTotalRow());
    }

    /**
     * 新增角色
     *
     * @param sysRoleFormVO 角色信息
     * @return 新增成功与否
     */
    @PostMapping
    public Boolean saveRole(
            @RequestBody
            @Validated(value = {Default.class, SysRoleSaveValidate.class})
            SysRoleFormVO sysRoleFormVO
    ) {
        return sysRoleService.save(SysRoleMapStruct.INSTANCE.toDO(sysRoleFormVO));
    }

    /**
     * 更新角色信息
     *
     * @param sysRoleFormVO 角色信息
     * @return 更新是否成功
     */
    @PutMapping
    public Boolean updateRole(
            @RequestBody
            @Validated(value = {Default.class, SysRoleUpdateValidate.class})
            SysRoleFormVO sysRoleFormVO
    ) {
        return sysRoleService.save(SysRoleMapStruct.INSTANCE.toDO(sysRoleFormVO));
    }

    /**
     * 移除角色
     *
     * @param ids id列表
     * @return 移除是否成功
     */
    @DeleteMapping
    public Boolean removeRoles(@NotEmpty List<Long> ids) {
        return sysRoleService.removeBatch(ids);
    }
}
