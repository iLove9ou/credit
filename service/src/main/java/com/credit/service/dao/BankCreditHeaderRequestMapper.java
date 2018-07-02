package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditHeaderRequestExample;
import com.credit.service.model.entity.BankCreditHeaderRequest;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BankCreditHeaderRequestMapper extends Mapper<BankCreditHeaderRequest> {
    int countByExample(BankCreditHeaderRequestExample example);

    int deleteByExample(BankCreditHeaderRequestExample example);

    List<BankCreditHeaderRequest> selectByExample(BankCreditHeaderRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditHeaderRequest record, @Param("example") BankCreditHeaderRequestExample example);

    int updateByExample(@Param("record") BankCreditHeaderRequest record, @Param("example") BankCreditHeaderRequestExample example);
}