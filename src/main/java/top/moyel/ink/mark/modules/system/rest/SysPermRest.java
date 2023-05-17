package top.moyel.ink.mark.modules.system.rest;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.moyel.ink.mark.modules.system.entity.SysPerm;
import top.moyel.ink.mark.modules.system.mapstruct.SysPermMapStruct;
import top.moyel.ink.mark.modules.system.service.ISysPermService;
import top.moyel.ink.mark.modules.system.vo.SysPermVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moyel
 * @folder 系统管理/权限管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/perm")
public class SysPermRest {
    private final ISysPermService sysPermService;

    /**
     * 权限树
     *
     * @return 权限树列表
     */
    @GetMapping("/tree/all")
    public List<Tree<Long>> getPermTree() {
        List<SysPerm> sysPermList = sysPermService.list();
        List<TreeNode<Long>> sysPermTreeNodeList = sysPermList.stream()
                .map(sysPerm -> {
                    TreeNode<Long> treeNode = new TreeNode<>(sysPerm.getId(), sysPerm.getParentId(), sysPerm.getPermDesc(), sysPerm.getSortNo());
                    treeNode.setExtra(JSONUtil.parseObj(SysPermMapStruct.INSTANCE.toVO(sysPerm)));
                    return treeNode;
                })
                .collect(Collectors.toList());

        return TreeUtil.build(sysPermTreeNodeList, null);
    }

    /**
     * 新增权限信息
     *
     * @param sysPermVO 权限信息
     * @return 是否成功
     */
    @PostMapping
    public Boolean saveSysPerm(@RequestBody SysPermVO sysPermVO) {
        return sysPermService.save(SysPermMapStruct.INSTANCE.toDO(sysPermVO));
    }

    /**
     * 修改权限信息
     *
     * @param sysPermVO 权限信息
     * @return 是否成功
     */
    @PutMapping
    public Boolean updateSysPerm(@RequestBody SysPermVO sysPermVO) {
        return sysPermService.update(SysPermMapStruct.INSTANCE.toDO(sysPermVO));
    }

    /**
     * 移除权限
     *
     * @param ids 权限id列表
     * @return 是否成功
     */
    @DeleteMapping
    public Boolean removeSysPerm(List<Long> ids) {
        return sysPermService.removeBatch(ids);
    }
}
