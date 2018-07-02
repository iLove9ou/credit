package com.credit.service.dao;


import com.credit.service.model.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public UserDO selectByPrimaryKey(String id);
}
