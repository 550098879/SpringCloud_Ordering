package org.zyx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.zyx.entity.Order;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/28.
 */
@Component
@FeignClient("order")
public interface OrderFeign {

    @PostMapping("/order/save")
    void save(Order order);

    @GetMapping("/order/findAll/{page}/{limit}/{uid}")
    Collection<Order> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit,@PathVariable("uid")long uid);

    @GetMapping("/order/findAllByState/{page}/{limit}")
    Collection<Order> findAllByState(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @PutMapping("/order/updateState/{id}")
    void updateState(@PathVariable("id") long id);

    @GetMapping("/order/counts")
    int counts();

}
