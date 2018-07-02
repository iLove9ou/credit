package com.credit.service.manager;


import com.credit.service.dao.BankCreditApplynotifyRequestMapper;
import com.credit.service.utils.DateUtil;
import common.credit.constants.Constants;
import common.credit.enums.CharsetEnum;
import common.credit.enums.SignTypeEnum;
import common.credit.format.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BankCreditManager {

    @Resource
    private BankCreditApplynotifyRequestMapper applynotifyRequestMapper;

    public Document getDocuemnt(String appId,
                                String funcKey,
                                String sign,
                                ResultInfo resultInfo) {

        Head head = getHead(appId,
                funcKey,
                DateUtil.currDate(),
                "r");

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
