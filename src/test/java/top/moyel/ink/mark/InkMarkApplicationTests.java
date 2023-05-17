package top.moyel.ink.mark;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.moyel.ink.mark.modules.system.entity.SysUser;
import top.moyel.ink.mark.modules.system.service.ISysUserService;

import java.util.List;

@SpringBootTest
class InkMarkApplicationTests {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
        List<SysUser> sysUserList = sysUserService.list();
        System.out.println(JSONUtil.toJsonPrettyStr(sysUserList));
        JsonNode jsonNode = objectMapper.valueToTree(sysUserList);
        System.out.println(jsonNode.toPrettyString());
    }
}
