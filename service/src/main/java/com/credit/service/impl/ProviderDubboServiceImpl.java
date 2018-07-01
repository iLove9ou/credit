package com.credit.service.impl;


import common.credit.domain.User;
import common.credit.dubbo.DubboService;
import com.alibaba.dubbo.config.annotation.Service;


@Service(version = "1.0.0")
public class ProviderDubboServiceImpl implements DubboService {

    @Override
    public User findByNickName(String nickName) {
        return new User();
    }
}
