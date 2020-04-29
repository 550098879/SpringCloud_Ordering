package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zyx.entity.User;

/**
 * Created by SunShine on 2020/4/28.
 */
@Repository
@Mapper
public interface UserRepository {

    @Select("select * from t_user where username=#{param1} and password=#{param2}")
    User login(String username, String password);
}
