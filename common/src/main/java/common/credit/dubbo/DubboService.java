package common.credit.dubbo;


import common.credit.domain.User;

public interface DubboService {

    User findByNickName(String nickName);
}
