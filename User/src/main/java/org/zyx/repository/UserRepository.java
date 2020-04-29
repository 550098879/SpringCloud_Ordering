package org.zyx.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.zyx.entity.User;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/28.
 */
@Repository
@Mapper
public interface UserRepository {

    @Select("select * from t_user limit #{param1},#{param2}")
    Collection<User> findAll(int page,int limit);

    @Select("select * from t_user where id=#{id}")
    User findById(@Param("id") long id);

    @Select("select count(1) from t_user")
    Integer counts();

    @Insert("insert into t_user(username,password,nickname,gender,telephone,registerdate,address) " +
            "values(#{username},#{password},#{nickname},#{gender},#{telephone},#{registerdate},#{address})")
    void save(User user);

    @Update("update t_user set username=#{username},nickname=#{nickname},gender=#{gender},telephone=#{telephone}," +
            "registerdate=#{registerdate},address=#{address} where id=#{id}")
    void update(User user);

    @Delete("delete from t_user where id=#{id}")
    void deleteById(@Param("id") long id);

}
