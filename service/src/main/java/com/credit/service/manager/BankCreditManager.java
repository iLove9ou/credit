package com.credit.service.manager;


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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BankCreditManager {

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
                return null;
            }
            BankCreditBodyResponse bodyResponse = bodyResponseMapper.selectByRequestId(requestId);

            if (bodyResponse == null) {
                return null;
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
        headerRequest.setAppid(documentInput.getRequest().getHead().getAppId());
        headerRequest.setFunction(documentInput.getRequest().getHead().getFunction());
        headerRequest.setInputcharset(documentInput.getRequest().getHead().getInputCharset());
        headerRequest.setReqmsgid(documentInput.getRequest().getHead().getReqMsgId());
        headerRequest.setReqtime(documentInput.getRequest().getHead().getRespTime());
        headerRequestMapper.insertSelective(headerRequest);

        BankCreditApplyNotifyRequest applyNotifyRequest = new BankCreditApplyNotifyRequest();
        applyNotifyRequest.setApplyno(documentInput.getRequest().getBody().getApplyNo());
        applyNotifyRequest.setCertname("certname");
        applyNotifyRequest.setCerttype("1");
        applyNotifyRequest.setBusinessmodel("model");
        applyNotifyRequest.setExtinfo("ext info");
        applynotifyRequestMapper.insertSelective(applyNotifyRequest);
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
