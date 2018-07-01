package common.credit.domain;

import common.credit.constants.Constants;

import java.io.Serializable;



public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String nickName;

    public User() {
        this.id = Long.MIN_VALUE;
        this.nickName = Constants.nick_name;
    }
}
