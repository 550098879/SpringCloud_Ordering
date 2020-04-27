package org.zyx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zyx.entity.MenuVO;

/**
 * Created by SunShine on 2020/4/27.
 */
@Component
@FeignClient(value="menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{currentPage}/{size}")
    MenuVO findAll(@PathVariable("currentPage")int currentPage, @PathVariable("size")int size);



}
