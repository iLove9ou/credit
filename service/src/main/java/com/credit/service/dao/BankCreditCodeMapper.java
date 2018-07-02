package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditCodeExample;
import com.credit.service.model.entity.BankCreditCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BankCreditCodeMapper {
    int countByExample(BankCreditCodeExample example);

    int deleteByExample(BankCreditCodeExample example);

    List<BankCreditCode> selectByExample(BankCreditCodeExample example);

    int updateByExampleSelective(@Param("record") BankCreditCode record, @Param("example") BankCreditCodeExample example);

    int updateByExample(@Param("record") BankCreditCode record, @Param("example") BankCreditCodeExample example);
}