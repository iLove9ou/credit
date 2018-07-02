package com.credit.service.dao;

import com.credit.service.dao.example.BankCreditApproveUploadRequestExample;
import com.credit.service.model.entity.BankCreditApproveUploadRequest;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BankCreditApproveUploadRequestMapper extends Mapper<BankCreditApproveUploadRequest> {
    int countByExample(BankCreditApproveUploadRequestExample example);

    int deleteByExample(BankCreditApproveUploadRequestExample example);

    List<BankCreditApproveUploadRequest> selectByExample(BankCreditApproveUploadRequestExample example);

    int updateByExampleSelective(@Param("record") BankCreditApproveUploadRequest record, @Param("example") BankCreditApproveUploadRequestExample example);

    int updateByExample(@Param("record") BankCreditApproveUploadRequest record, @Param("example") BankCreditApproveUploadRequestExample example);
}