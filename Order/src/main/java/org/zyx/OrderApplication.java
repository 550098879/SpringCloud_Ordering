package org.zyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**订单管理
 * Created by SunShine on 2020/4/26.
 */
@SpringBootApplication
@MapperScan("org.zyx.repository")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);

    }

}
