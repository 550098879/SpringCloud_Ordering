package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zyx.entity.Type;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/27.
 */
@Mapper
@Repository
public interface TypeRepository {

    Type findById(@Param("id") long id);

    @Select("select * from t_type")
    Collection<Type> findAll();
}
