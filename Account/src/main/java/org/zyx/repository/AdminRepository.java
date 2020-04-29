package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zyx.entity.Admin;

/**
 * Created by SunShine on 2020/4/28.
 */
@Repository
@Mapper
public interface AdminRepository {

    @Select("select * from t_admin where username=#{param1} and password=#{param2}")
    Admin login(String username,String password);

}
