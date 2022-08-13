package com.zlh.cloudalibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lh
 */
public interface AccountService {

    /**
     * 扣减账户金额
     * @param userId  用户ID
     * @param money  金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
