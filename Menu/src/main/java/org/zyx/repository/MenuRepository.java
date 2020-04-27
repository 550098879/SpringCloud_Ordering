package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zyx.entity.Menu;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/27.
 */
@Repository
@Mapper     //设为Mapper,省去启动类的注解,简单sql语句也可以在这里写
public interface MenuRepository {


    Collection<Menu> findAll(int currentPage,int size);

    @Select("select count(1) from t_menu")
    int counts();

    Menu findById(long id);

    int save(Menu menu);

    int update(Menu menu);

    int deleteById(long id);

}
