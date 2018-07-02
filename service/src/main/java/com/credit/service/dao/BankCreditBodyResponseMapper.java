package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditBodyResponseExample;
import com.credit.service.model.entity.BankCreditBodyResponse;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BankCreditBodyResponseMapper extends Mapper<BankCreditBodyResponse> {

    BankCreditBodyResponse selectByRequestId(@Param("requestId") String requestId);

    int countByExample(BankCreditBodyResponseExample example);

    int deleteByExample(BankCreditBodyResponseExample example);

    List<BankCreditBodyResponse> selectByExample(BankCreditBodyResponseExample example);

    int updateByExampleSelective(@Param("record") BankCreditBodyResponse record, @Param("example") BankCreditBodyResponseExample example);

    int updateByExample(@Param("record") BankCreditBodyResponse record, @Param("example") BankCreditBodyResponseExample example);
}