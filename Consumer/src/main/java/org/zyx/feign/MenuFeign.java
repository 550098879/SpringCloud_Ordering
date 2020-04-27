package org.zyx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.Menu;
import org.zyx.entity.MenuVO;
import org.zyx.entity.Type;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/27.
 */
@Component
@FeignClient(value="menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{currentPage}/{size}")
    MenuVO findAll(@PathVariable("currentPage")int currentPage, @PathVariable("size")int size);

    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    Collection<Type> findTypes();

    /**
     * 发送数据是以json格式发送的,所以在服务接收的时候要用@RequestBody接收
     * @param menu
     */
    @PostMapping("/menu/save")
    void save(Menu menu);

    @PutMapping("/menu/update")
    void update(Menu menu);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);
}
