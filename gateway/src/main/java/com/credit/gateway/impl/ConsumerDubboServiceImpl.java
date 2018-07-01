package com.credit.gateway.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import common.credit.constants.Constants;
import common.credit.domain.User;
import common.credit.dubbo.DubboService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerDubboServiceImpl {

    @Reference(version = "1.0.0")
    private DubboService dubboService;

    public void print() {
        User user = dubboService.findByNickName(Constants.nick_name);
        System.out.println(user.toString());
    }
}
