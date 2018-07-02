package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApproveackNotifyRequestExample;
import com.credit.service.model.entity.BankCreditApproveackNotifyRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BankCreditApproveackNotifyRequestMapper {

    int countByExample(BankCreditApproveackNotifyRequestExample example);

    int deleteByExample(BankCreditApproveackNotifyRequestExample example);

    List<BankCreditApproveackNotifyRequest> selectByExample(BankCreditApproveackNotifyRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApproveackNotifyRequest record, @Param("example") BankCreditApproveackNotifyRequestExample example);

    int updateByExample(@Param("record") BankCreditApproveackNotifyRequest record, @Param("example") BankCreditApproveackNotifyRequestExample example);
}