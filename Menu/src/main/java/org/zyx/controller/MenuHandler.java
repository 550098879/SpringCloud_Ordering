package org.zyx.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.zyx.entity.Menu;
import org.zyx.entity.MenuVO;
import org.zyx.entity.Type;
import org.zyx.repository.MenuRepository;
import org.zyx.repository.TypeRepository;

import java.util.ArrayList;
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

    @Autowired
    private TypeRepository typeRepository;

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

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }

    @GetMapping("/findTypes")
    public Collection<Type> findTypes(){
        return typeRepository.findAll();
    }

    /**
     * @RequestBody 将json数据接转换为对象
     * @param menu
     */
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }

}
