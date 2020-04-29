package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyx.entity.Menu;
import org.zyx.entity.Order;
import org.zyx.entity.OrderVO;
import org.zyx.entity.User;
import org.zyx.feign.OrderFeign;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;

/**
 * Created by SunShine on 2020/4/28.
 */
@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(HttpSession session,@PathVariable("mid") int mid){
        User user = (User) session.getAttribute("user");
        Order order =new Order();
        order.setDate(new Date());
        order.setUser(user);

        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);

        orderFeign.save(order);

        return "order";
    }

    @ResponseBody
    @GetMapping("/findAllByUid")
    public OrderVO findAll(int page, int limit, HttpSession session){
        User user = (User) session.getAttribute("user");

        Collection<Order> orderList=orderFeign.findAll(page, limit,user.getId());

        return new OrderVO(0,"",orderFeign.counts(),orderList);
    }

    @ResponseBody
    @GetMapping("/findAllByState")
    public OrderVO findAllByState(int page, int limit){

        Collection<Order> orderList=orderFeign.findAllByState(page, limit);

        return new OrderVO(0,"",orderFeign.counts(),orderList);
    }

    @GetMapping("/updateState/{id}/{state}")
    public String updateState(@PathVariable("id") long id,@PathVariable("state") int state){

        orderFeign.updateState(id);

        return "order_handler";
    }

}
