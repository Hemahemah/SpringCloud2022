package com.zlh.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author lh
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     * @param userId userId
     * @param money money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
