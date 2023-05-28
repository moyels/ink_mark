package top.moyel.ink.mark.modules.system.utils;

import top.moyel.ink.mark.modules.system.entity.SysRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author moyel
 */
public class SysRoleUtil {
    public static List<Long> getParentRoleIds(List<SysRole> roleList, Long roleId) {
        return getParentRoleIds(roleList, roleId, null);
    }

    public static List<Long> getParentRoleIds(List<SysRole> roleList, Long roleId, Long topParentId) {
        return getParentRoleIds(roleList, SysRole::getId, SysRole::getParentRole, roleId, topParentId);
    }

    public static <ID, T> List<ID> getParentRoleIds(List<T> roleList, Function<T, ID> idMapper, Function<T, ID> parentIdMapper, ID roleId, ID topParentId) {
        Map<ID, T> roleMap = roleList.stream().collect(Collectors.toMap(idMapper, entity -> entity));
        return getParentRoleIds(roleMap, parentIdMapper, roleId, topParentId);
    }

    public static <ID, T> List<ID> getParentRoleIds(Map<ID, T> roleMap, Function<T, ID> parentIdMapper, ID roleId, ID topParentId) {
        ID currentId = roleId;
        List<ID> roleIds = new ArrayList<>();

        while (roleMap.containsKey(currentId)) {
            roleIds.add(currentId);
            T sysRole = roleMap.get(currentId);
            ID parentId = parentIdMapper.apply(sysRole);

            if (Objects.equals(parentId, topParentId)) {
                break;
            }

            currentId = parentId;
        }

        return roleIds;
    }
}
