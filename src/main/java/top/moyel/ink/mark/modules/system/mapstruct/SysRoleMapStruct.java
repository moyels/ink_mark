package top.moyel.ink.mark.modules.system.mapstruct;

import org.mapstruct.factory.Mappers;
import top.moyel.ink.mark.modules.system.entity.SysRole;
import top.moyel.ink.mark.modules.system.vo.SysRoleFormVO;

public interface SysRoleMapStruct {
    SysRoleMapStruct INSTANCE = Mappers.getMapper(SysRoleMapStruct.class);

    SysRole toDO(SysRoleFormVO sysRoleFormVO);
}
