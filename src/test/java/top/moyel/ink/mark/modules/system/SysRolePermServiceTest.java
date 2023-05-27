package top.moyel.ink.mark.modules.system;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.moyel.ink.mark.modules.system.entity.SysRolePerm;
import top.moyel.ink.mark.modules.system.service.ISysRolePermService;

import java.util.List;

@Slf4j
@SpringBootTest
public class SysRolePermServiceTest {
    @Autowired
    private ISysRolePermService sysRolePermService;

    @Test
    public void listAll() {
        List<SysRolePerm> list = sysRolePermService.list();
        log.info(JSONUtil.toJsonStr(list));
    }
}
