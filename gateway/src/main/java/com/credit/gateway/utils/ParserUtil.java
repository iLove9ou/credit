package com.credit.gateway.utils;

import com.alipay.sdk.*;
import com.alipay.sdk.internal.parser.xml.ObjectXmlParser;
import com.alipay.sdk.internal.util.AlipayLogger;
import com.alipay.sdk.internal.util.StringUtils;

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
}
