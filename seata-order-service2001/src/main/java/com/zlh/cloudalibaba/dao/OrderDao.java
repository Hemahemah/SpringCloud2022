package com.zlh.cloudalibaba.dao;
import com.zlh.cloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lh
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单状态，从0改为1
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
