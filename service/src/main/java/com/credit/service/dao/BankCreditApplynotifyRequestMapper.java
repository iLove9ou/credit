package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApplynotifyRequestExample;
import com.credit.service.model.entity.BankCreditApplynotifyRequest;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BankCreditApplynotifyRequestMapper extends Mapper<BankCreditApplynotifyRequest> {
    int countByExample(BankCreditApplynotifyRequestExample example);

    int deleteByExample(BankCreditApplynotifyRequestExample example);

    List<BankCreditApplynotifyRequest> selectByExample(BankCreditApplynotifyRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApplynotifyRequest record, @Param("example") BankCreditApplynotifyRequestExample example);

    int updateByExample(@Param("record") BankCreditApplynotifyRequest record, @Param("example") BankCreditApplynotifyRequestExample example);
}