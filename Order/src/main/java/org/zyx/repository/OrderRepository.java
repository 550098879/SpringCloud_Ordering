package org.zyx.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zyx.entity.Order;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/28.
 */
@Repository
@Mapper
public interface OrderRepository {

    Collection<Order> findAll(int page,int limit,long uid);

    void save(Order order);

    /**
     *  查找所有未处理订单
     * @param page
     * @param limit
     * @return
     */
    Collection<Order> findAllByState(int page,int limit);

    /**
     * 处理订单
     * @param id
     */
    void update(long id);

    @Select("select count(1) from t_order")
    int counts();

}
