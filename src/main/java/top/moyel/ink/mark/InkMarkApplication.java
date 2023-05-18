package top.moyel.ink.mark;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author spring boot
 */
@SpringBootApplication
@Import(SpringUtil.class)
public class InkMarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(InkMarkApplication.class, args);
    }

}
