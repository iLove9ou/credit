package com.credit.client.domain;

import com.credit.client.constants.Constants;
import lombok.Data;

import java.io.Serializable;


@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String nickName;

    public User() {
        this.id = Long.MIN_VALUE;
        this.nickName = Constants.nick_name;
    }
}
