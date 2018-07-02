/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.mybank;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApproveackConfirmDomain;
import com.alipay.sdk.enums.BooleanEnum;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.credit.gateway.demo.KeyConstants;

/**
 * ���̴�-������������ȷ��-DEMO
 *
 * @author azheng
 * @version $Id: MybankCreditLoanApproveackConfirmDemo.java, v 0.1 2018-04-09 azheng Exp $
 */
public class MybankCreditLoanApproveackConfirmDemo {

    public static void main(String[] args) throws Exception {

        //1.TODO ҵ����

        //2. ��װ���Ķ���
        AlipayTemplate template = new DefaultAlipayTemplate("HNXT85", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);

        MybankCreditLoanApproveackConfirmRequest request = new MybankCreditLoanApproveackConfirmRequest();
        MybankCreditLoanApproveackConfirmDomain bizMode = new MybankCreditLoanApproveackConfirmDomain();

        bizMode.setRequestId("226610000052162968501_3c205f628689482ba18da319c269c70b");
        bizMode.setApplyNo("2018042810102500100009336452B");
        bizMode.setCertName("������");
        bizMode.setCertNo("412223197311033616");
        bizMode.setIsAgree(BooleanEnum.FALSE.getCode());
        bizMode.setRefuseCode("reason_code_04");
        bizMode.setAckMsg("��ʷ���Ų���");
        bizMode.setExtInfo("{\"creditAmt\": \"5100000\", \"creditRate\": \"0.08000000\"}");
        request.setBizModel(bizMode);

        //3.ִ�з��ͱ���
        try {
            ParametersHolder execute = template
                    .execute("http://supergwext-1-64.test.dl.alipaydev.com/HNXT85/HNXT8579172.htm", request);

            //LOGGER.info(execute.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();

            if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                //��ǩ���� ������
                //LOGGER.debug(result.getSignItem().getSign());
            } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode().equals(e.getErrCode())) {
                //�Ƿ�����
            } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {
                //����У��ʧ��
                //} else if (..������Ҫ���⴦��Ĵ�����..) {
                //......
            } else {
                if (e.isRetry()) {
                    //�ط�
                }
            }
        }
    }

}