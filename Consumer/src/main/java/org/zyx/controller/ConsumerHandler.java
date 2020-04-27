package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.MenuVO;
import org.zyx.feign.MenuFeign;

/**
 * Created by SunShine on 2020/4/27.
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }


    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int currentPage, @RequestParam("limit")int size){
        return menuFeign.findAll(currentPage, size);
    }

}
