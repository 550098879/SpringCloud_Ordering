package org.zyx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.User;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/28.
 */
@Component
@FeignClient(value = "user")
public interface UserFeign {


    @GetMapping("/user/findAll/{page}/{limit}")
    Collection<User> findAll(@PathVariable("page") int page,@PathVariable("limit") int limit);

    @GetMapping("/user/findById/{id}")
    User findById(@PathVariable("id") long id);

    @GetMapping("/user/counts")
    int counts();

    @PostMapping("/user/save")
    void save( User user);

    @PutMapping("/user/update")
    void update(User user);

    @DeleteMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);

}
