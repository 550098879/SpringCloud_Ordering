package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zyx.entity.User;
import org.zyx.entity.UserVO;
import org.zyx.feign.UserFeign;

import java.util.Collection;
import java.util.Date;

/**
 * Created by SunShine on 2020/4/27.
 */
@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit")int limit){

        return new UserVO(0,"",userFeign.counts(),userFeign.findAll(page, limit));
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }

    @PostMapping("/save")
    public String save(User u){
        u.setRegisterdate(new Date());
        userFeign.save(u);
        return "redirect:/user/redirect/user_manage";
    }


}
