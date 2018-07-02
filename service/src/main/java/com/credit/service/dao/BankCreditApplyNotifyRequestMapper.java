package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApplynotifyRequestExample;
import com.credit.service.model.entity.BankCreditApplyNotifyRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BankCreditApplyNotifyRequestMapper {

    void insertSelective(BankCreditApplyNotifyRequest record);

    int countByExample(BankCreditApplynotifyRequestExample example);

    int deleteByExample(BankCreditApplynotifyRequestExample example);

    List<BankCreditApplyNotifyRequest> selectByExample(BankCreditApplynotifyRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApplyNotifyRequest record, @Param("example") BankCreditApplynotifyRequestExample example);

    int updateByExample(@Param("record") BankCreditApplyNotifyRequest record, @Param("example") BankCreditApplynotifyRequestExample example);
}