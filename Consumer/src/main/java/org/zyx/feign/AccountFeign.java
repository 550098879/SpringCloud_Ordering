package org.zyx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by SunShine on 2020/4/28.
 */
@Component
@FeignClient("accounts")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);

}
