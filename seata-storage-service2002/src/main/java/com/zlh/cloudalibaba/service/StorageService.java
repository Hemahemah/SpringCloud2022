package com.zlh.cloudalibaba.service;

/**
 * @author lh
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
