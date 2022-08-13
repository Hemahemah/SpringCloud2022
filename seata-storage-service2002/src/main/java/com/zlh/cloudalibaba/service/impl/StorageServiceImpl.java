package com.zlh.cloudalibaba.service.impl;

import com.zlh.cloudalibaba.dao.StorageDao;
import com.zlh.cloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lh
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-------->storage-service中扣减库存");
        storageDao.decrease(productId, count);
    }
}
