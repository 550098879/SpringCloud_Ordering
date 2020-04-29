package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zyx.entity.User;

/**
 * Created by SunShine on 2020/4/29.
 */
@Mapper
public interface UserRepository {

    @Select("select * from t_user where id=#{id}")
    User findById(long id);

}
