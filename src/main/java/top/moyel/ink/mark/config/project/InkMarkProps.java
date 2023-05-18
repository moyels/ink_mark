package top.moyel.ink.mark.config.project;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author moyel
 */
@Data
@ConfigurationProperties("ink.mark")
public class InkMarkProps {
    /**
     * 默认密码
     */
    private String defaultPassword = "123456";
}
