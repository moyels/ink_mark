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

@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/perm")
public class SysPermRest {
    private final ISysPermService sysPermService;

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

    @PostMapping
    public Boolean saveSysPerm(@RequestBody SysPermVO sysPermVO) {
        return sysPermService.save(SysPermMapStruct.INSTANCE.toDO(sysPermVO));
    }

    @PutMapping
    public Boolean updateSysPerm(@RequestBody SysPermVO sysPermVO) {
        return sysPermService.update(SysPermMapStruct.INSTANCE.toDO(sysPermVO));
    }

    @DeleteMapping
    public Boolean removeSysPerm(List<Long> ids) {
        return sysPermService.removeBatch(ids);
    }
}
