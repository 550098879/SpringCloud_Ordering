package org.zyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by SunShine on 2020/4/27.
 */
@SpringBootApplication
//@MapperScan("org.zyx.repository") //自动扫描(添加了Mapper注解也可以)
public class MenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class,args);
    }
}
