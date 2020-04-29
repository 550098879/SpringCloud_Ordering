package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zyx.entity.Admin;
import org.zyx.repository.AdminRepository;
import org.zyx.repository.UserRepository;

/**
 * Created by SunShine on 2020/4/28.
 */
@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;


    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){

        if(type.equals("user")){
            return userRepository.login(username, password);
        }
        else if(type.equals("admin")){
            return adminRepository.login(username, password);
        }

        return null;
    }

}
