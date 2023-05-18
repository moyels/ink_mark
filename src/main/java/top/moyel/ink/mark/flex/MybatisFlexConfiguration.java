package top.moyel.ink.mark.flex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author moyel
 */
@Configuration
@MapperScan("top.moyel.ink.mark.modules.*.mapper")
public class MybatisFlexConfiguration {
}
