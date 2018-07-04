package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApproveUploadRequestExample;
import com.credit.service.model.entity.BankCreditApproveUploadRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BankCreditApproveUploadRequestMapper {

    void insertSelective(BankCreditApproveUploadRequest request);

    int countByExample(BankCreditApproveUploadRequestExample example);

    int deleteByExample(BankCreditApproveUploadRequestExample example);

    List<BankCreditApproveUploadRequest> selectByExample(BankCreditApproveUploadRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApproveUploadRequest record, @Param("example") BankCreditApproveUploadRequestExample example);

    int updateByExample(@Param("record") BankCreditApproveUploadRequest record, @Param("example") BankCreditApproveUploadRequestExample example);
}