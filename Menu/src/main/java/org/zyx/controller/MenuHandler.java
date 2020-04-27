package org.zyx.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.Menu;
import org.zyx.entity.MenuVO;
import org.zyx.repository.MenuRepository;

import java.util.Collection;

/**菜单控制器
 * Created by SunShine on 2020/4/27.
 */
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private int port;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/index")
    public String index(){

        return "端口是:"+this.port;
    }

    @GetMapping("findAll/{currentPage}/{size}")
    public MenuVO findAll(@PathVariable("currentPage") int currentPage, @PathVariable("size") int size){
        Collection<Menu> data=menuRepository.findAll((currentPage-1)*size,size);
        return new MenuVO(0,"测试",menuRepository.counts(),data);
    }

    @GetMapping("/counts")
    public Integer counts(){
        return menuRepository.counts();
    }

}
