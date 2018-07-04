package com.credit.gateway.utils;

import com.alipay.sdk.*;
import com.alipay.sdk.internal.parser.xml.ObjectXmlGenerator;
import com.alipay.sdk.internal.parser.xml.ObjectXmlParser;
import com.alipay.sdk.internal.util.AlipayLogger;
import com.alipay.sdk.internal.util.StringUtils;
import com.alipay.sdk.internal.util.XmlUtils;
import common.credit.constants.Constants;
import org.w3c.dom.Document;

public class ParserUtil {

    public static ParametersHolder parse(String payload, Class<? extends AlipayRequest> requestClass) throws AlipayApiException {

        if (StringUtils.isEmpty(payload)) {
            throw new AlipayApiException(AlipayErrorCode.ILLEGAL_ARGUMENT, "XML_PAYLOAD_EMPTY");
        } else {
            AlipayRequest request = null;
            try {
                request = (AlipayRequest) requestClass.newInstance();
            } catch (InstantiationException e) {
                throw new AlipayApiException(e);
            } catch (IllegalAccessException e) {
                throw new AlipayApiException(e);
            }
            AlipayParser parser = new ObjectXmlParser(request.getRequestClass());
            ParametersHolder requestHolder = parser.parse(payload);
            requestHolder.setRequest(true);
            AlipayLogger.logBizDebug("解析所得模型 : " + requestHolder.toString());
            return requestHolder;
        }
    }

    public static String toxml(ParametersHolder responseHolder) {
        try {
            ObjectXmlGenerator generator = new ObjectXmlGenerator();
            Document doc = ObjectXmlGenerator.getXmlDoc(responseHolder);
            SignItem signItem = ObjectXmlGenerator.setSignItem(doc, responseHolder, Constants.privateKey);
            responseHolder.setSignItem(signItem);
            String rspBody = XmlUtils.nodeToString(doc.getFirstChild());
            AlipayLogger.logBizInfo("holder转换结果：" + rspBody);
            return rspBody;
        } catch (Exception e) {
            return null;
        }
    }
}
