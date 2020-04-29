package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zyx.entity.Menu;

/**
 * Created by SunShine on 2020/4/28.
 */
@Mapper
public interface MenuRepository {

    @Select("select * from t_menu where id=#{param1}")
    Menu findById(long id);

}
