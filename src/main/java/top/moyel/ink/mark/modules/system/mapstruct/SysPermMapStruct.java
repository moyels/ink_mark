package top.moyel.ink.mark.modules.system.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.moyel.ink.mark.modules.system.entity.SysPerm;
import top.moyel.ink.mark.modules.system.vo.SysPermVO;

/**
 * @author moyel
 */
@Mapper
public interface SysPermMapStruct {
    SysPermMapStruct INSTANCE = Mappers.getMapper(SysPermMapStruct.class);

    SysPermVO toVO(SysPerm sysPerm);

    SysPerm toDO(SysPermVO sysPermVO);
}
