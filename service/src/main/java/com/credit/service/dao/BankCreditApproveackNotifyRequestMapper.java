package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApproveackNotifyRequestExample;
import com.credit.service.model.entity.BankCreditApproveackNotifyRequest;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BankCreditApproveackNotifyRequestMapper extends Mapper<BankCreditApproveackNotifyRequest> {
    int countByExample(BankCreditApproveackNotifyRequestExample example);

    int deleteByExample(BankCreditApproveackNotifyRequestExample example);

    List<BankCreditApproveackNotifyRequest> selectByExample(BankCreditApproveackNotifyRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApproveackNotifyRequest record, @Param("example") BankCreditApproveackNotifyRequestExample example);

    int updateByExample(@Param("record") BankCreditApproveackNotifyRequest record, @Param("example") BankCreditApproveackNotifyRequestExample example);
}