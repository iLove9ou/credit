package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApproveackConfirmRequestExample;
import com.credit.service.model.entity.BankCreditApproveackConfirmRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BankCreditApproveackConfirmRequestMapper {

    void insertSelective(BankCreditApproveackConfirmRequest record);

    int countByExample(BankCreditApproveackConfirmRequestExample example);

    int deleteByExample(BankCreditApproveackConfirmRequestExample example);

    List<BankCreditApproveackConfirmRequest> selectByExample(BankCreditApproveackConfirmRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApproveackConfirmRequest record, @Param("example") BankCreditApproveackConfirmRequestExample example);

    int updateByExample(@Param("record") BankCreditApproveackConfirmRequest record, @Param("example") BankCreditApproveackConfirmRequestExample example);
}