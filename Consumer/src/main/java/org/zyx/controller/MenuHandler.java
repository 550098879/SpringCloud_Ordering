package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zyx.entity.Menu;
import org.zyx.entity.MenuVO;
import org.zyx.feign.MenuFeign;

/**
 * Created by SunShine on 2020/4/27.
 */
@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }


    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int currentPage, @RequestParam("limit")int size){
        MenuVO all = menuFeign.findAll(currentPage, size);
        return all;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id,ModelAndView modelAndView){

        modelAndView.addObject("list",menuFeign.findTypes());
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.setViewName("menu_update");
        return modelAndView;
}

    @GetMapping("/findTypes")
    public ModelAndView findTypes( ModelAndView modelAndView){
        modelAndView.addObject("list", menuFeign.findTypes());
        modelAndView.setViewName("menu_add");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }

}
