package com.credit.client.dubbo;

import com.credit.client.domain.User;


public interface DubboService {

    User findByNickName(String nickName);
}
