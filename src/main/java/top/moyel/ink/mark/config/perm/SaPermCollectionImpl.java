package top.moyel.ink.mark.config.perm;

import cn.dev33.satoken.stp.StpInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import top.moyel.ink.mark.modules.system.service.ISysPermService;
import top.moyel.ink.mark.modules.system.service.ISysRoleService;

import java.util.List;

/**
 * @author moyel
 */
@Component
@RequiredArgsConstructor
public class SaPermCollectionImpl implements StpInterface {
    private final ISysRoleService sysRoleService;
    private final ISysPermService sysPermService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
