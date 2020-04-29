package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.Admin;
import org.zyx.entity.User;
import org.zyx.feign.AccountFeign;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

/**
 * Created by SunShine on 2020/4/28.
 */
@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }

    @PostMapping("/login")
    public String login(String username, String password, String type,HttpSession session){

        LinkedHashMap<String,Object> acc= (LinkedHashMap) accountFeign.login(username, password, type);

        if(acc != null){
            if(type.equals("user")){
                User user=new User();
                user.setId((int)acc.get("id"));
                user.setUsername((String) acc.get("username"));
                user.setNickname((String) acc.get("nickname"));

                session.setAttribute("user",user);
                return "index";
            }else if(type.equals("admin")){
                Admin admin=new Admin();
                admin.setId((int) acc.get("id"));
                admin.setUsername((String) acc.get("username"));
                session.setAttribute("admin",admin);

                return "main";
            }
        }

        return "login";
    }

    @GetMapping("/logout")
    public  String logout(HttpSession session){

        session.invalidate();//直接销毁
        return "login";
    }


}
