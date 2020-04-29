package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.Order;
import org.zyx.repository.OrderRepository;

import java.util.Collection;
import java.util.Date;

/**
 * Created by SunShine on 2020/4/26.
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/findAll/{page}/{limit}/{uid}")
    public Collection<Order> findAll(@PathVariable("page") int page,@PathVariable("limit") int limit,@PathVariable("uid")long uid){
        return orderRepository.findAll(page,limit,uid);
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderRepository.save(order);
    }

    //待处理
    @GetMapping("/findAllByState/{page}/{limit}")
    public Collection<Order> findAllByState(@PathVariable("page") int page,@PathVariable("limit") int limit){
        return orderRepository.findAllByState(page, limit);
    }

    @PutMapping("/updateState/{id}")
    public void update(@PathVariable("id") long id){
        orderRepository.update(id);
    }

    @GetMapping("/counts")
    public int counts(){
        return orderRepository.counts();
    }

}
