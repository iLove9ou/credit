package com.credit.service.manager;


import com.alipay.sdk.AlipayHeader;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.credit.service.dao.*;
import com.credit.service.model.entity.BankCreditApplyNotifyRequest;
import com.credit.service.model.entity.BankCreditBodyResponse;
import com.credit.service.model.entity.BankCreditHeaderRequest;
import com.credit.service.model.entity.BankCreditHeaderResponse;
import com.credit.service.utils.DateUtil;
import common.credit.constants.Constants;
import common.credit.enums.CharsetEnum;
import common.credit.enums.SignTypeEnum;
import common.credit.format.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class BankCreditManager {

    private final static Logger logger = LoggerFactory.getLogger(BankCreditManager.class);


    @Resource
    private BankCreditHeaderRequestMapper headerRequestMapper;

    @Resource
    private BankCreditApplyNotifyRequestMapper applynotifyRequestMapper;

    @Resource
    private BankCreditCodeMapper creditCodeMapper;

    @Resource
    private BankCreditHeaderResponseMapper headerResponseMapper;

    @Resource
    private BankCreditBodyResponseMapper bodyResponseMapper;


    public Document getDocuemnt(String requestId,
                                String appId,
                                String funcKey,
                                String sign,
                                ResultInfo resultInfo) {

        if (Constants.IS_DEBUG == 1) {
            Head head = getHead(appId,
                    funcKey,
                    DateUtil.currDate(),
                    Constants.SYSTEM_VERSION);

            Body body = new Body();
            body.setApplyNo(DateUtil.currDate());
            body.setRequestId(DateUtil.currDate());
            body.setResultInfo(resultInfo);

            Signature signature = new Signature();
            signature.setSignature(sign);

            Response response = new Response(head, body);

            Document document = new Document();
            document.setResponse(response);
            document.setSignature(signature);
            return document;
        } else {
            BankCreditHeaderResponse headerResponse = headerResponseMapper.selectByRequestId(requestId);

            if (headerResponse == null) {
                Document document = new Document();
                return document;
            }
            BankCreditBodyResponse bodyResponse = bodyResponseMapper.selectByRequestId(requestId);

            if (bodyResponse == null) {
                Document document = new Document();
                return document;
            }

            Head head = new Head();
            Body body = new Body();
            BeanUtils.copyProperties(headerResponse, head);
            BeanUtils.copyProperties(bodyResponse, body);

            Signature signature = new Signature();
            signature.setSignature(sign);

            Response response = new Response(head, body);

            Document document = new Document();
            document.setResponse(response);
            document.setSignature(signature);
            return document;
        }
    }

    public void addDocument(DocumentInput documentInput) {

        BankCreditHeaderRequest headerRequest = new BankCreditHeaderRequest();
        headerRequest.setAppId(documentInput.getRequest().getHead().getAppId());
        headerRequest.setFunction(documentInput.getRequest().getHead().getFunction());
        headerRequest.setReqMsgId(documentInput.getRequest().getHead().getReqMsgId());
        headerRequest.setReqTime(documentInput.getRequest().getHead().getRespTime());
        headerRequest.setVersion(documentInput.getRequest().getHead().getVersion());
        headerRequest.setSignType(documentInput.getRequest().getHead().getSignType());
        headerRequest.setInputCharset(documentInput.getRequest().getHead().getInputCharset());
        headerRequestMapper.insertSelective(headerRequest);

        BankCreditApplyNotifyRequest applyNotifyRequest = new BankCreditApplyNotifyRequest();
        applyNotifyRequest.setApplyno(documentInput.getRequest().getBody().getApplyNo());
        applyNotifyRequest.setCertname("certname");
        applyNotifyRequest.setCerttype("1");
        applyNotifyRequest.setBusinessmodel("model");
        applyNotifyRequest.setExtinfo("ext info");
        applynotifyRequestMapper.insertSelective(applyNotifyRequest);
    }

    @Transactional
    public void insertApplyNotify(AlipayHeader head,
                                  MybankCreditLoanApplyNotifyDomain domain,
                                  MybankCreditLoanApplyNotifyResponse response) {

        BankCreditHeaderRequest headerRequest = new BankCreditHeaderRequest();
        MybankCreditLoanApplyNotifyDomain body = domain;
        AlipayHeader header = head;
        BeanUtils.copyProperties(header, headerRequest);

        headerRequestMapper.insertSelective(headerRequest);

        BankCreditHeaderResponse headerResponse = new BankCreditHeaderResponse();
        BeanUtils.copyProperties(header, headerResponse);
        headerResponseMapper.insertSelective(headerResponse);

        BankCreditBodyResponse bodyResponse = new BankCreditBodyResponse();

        bodyResponse.setApplyNo(response.getApplyNo());
        bodyResponse.setRequestId(response.getRequestId());
        bodyResponse.setResultCode(response.getResultInfo().getResultCode());
        bodyResponse.setResultMsg(response.getResultInfo().getResultMsg());
        bodyResponse.setRetry(response.getResultInfo().getRetry());
        bodyResponseMapper.insertSelective(bodyResponse);

    }

    private Head getHead(String appId, String function, String reqMsgId, String reverse) {
        Head head = new Head();
        head.setVersion(Constants.SYSTEM_VERSION);
        head.setSignType(SignTypeEnum.RSA.name());
        head.setRespTime(DateUtil.currDate());
        head.setInputCharset(CharsetEnum.UTF8.name());
        head.setAppId(appId);
        head.setFunction(function);
        head.setReqMsgId(reqMsgId);
        head.setReverse(reverse);
        return head;
    }

}
