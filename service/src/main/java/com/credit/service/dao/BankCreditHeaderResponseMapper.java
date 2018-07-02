package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditHeaderResponseExample;
import com.credit.service.model.entity.BankCreditHeaderResponse;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BankCreditHeaderResponseMapper extends Mapper<BankCreditHeaderResponse> {

    BankCreditHeaderResponse selectByRequestId(@Param("requestId") String requestId);

    int countByExample(BankCreditHeaderResponseExample example);

    int deleteByExample(BankCreditHeaderResponseExample example);

    List<BankCreditHeaderResponse> selectByExample(BankCreditHeaderResponseExample example);

    int updateByExampleSelective(@Param("record") BankCreditHeaderResponse record, @Param("example") BankCreditHeaderResponseExample example);

    int updateByExample(@Param("record") BankCreditHeaderResponse record, @Param("example") BankCreditHeaderResponseExample example);
}