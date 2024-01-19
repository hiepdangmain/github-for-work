package com.msb.ibs.common.integration.esb;

import com.msb.ibs.common.constant.EsbConstants;
import com.msb.ibs.common.integration.esb.input.EsbAuthInfo;
import com.msb.ibs.common.integration.esb.input.EsbRootRequest;
import com.msb.ibs.common.integration.esb.output.EsbRespMessage;
import com.msb.ibs.common.utils.ConverterUtil;

import java.util.Date;

public class EsbUtils {

    public static EsbRootRequest buildEsbRootRequest(String fieldName, Object data) {
        return new EsbRootRequest().build(fieldName, data);
    }

    public static EsbAuthInfo buildAuthentication(String srvName, String reqApp, String username, String password) {
        return buildAuthentication(srvName, reqApp, username, password,  ConverterUtil.toString(new Date(), "yyyyMMddHHmmssSSS"));
    }

    public static EsbAuthInfo buildAuthentication(String srvName, String reqApp, String username, String password, String requestId) {
        Date now = new Date();
        return EsbAuthInfo.builder()
                .srv(srvName)
                .authorizer(username)
                .password(password)
                .req_app(reqApp)
                .req_id(requestId)
                .req_time(ConverterUtil.toString(now, "dd-MM-yyyy HH:mm:ss.SSS"))
                .build();
    }

    public static EsbAuthInfo buildAuthentication(BkConfigQueue configQueue) {
        Date now = new Date();
        return EsbAuthInfo.builder()
                .srv(configQueue.getSrv())
                .authorizer(configQueue.getHeaderAuthorizer())
                .password(configQueue.getHeaderPassword())
                .req_app(configQueue.getHeaderReqApp())
                .req_id(ConverterUtil.toString(now, "yyyyMMddHHmmssSSS"))
                .req_time(ConverterUtil.toString(now, "dd-MM-yyyy HH:mm:ss.SSS"))
                .build();
    }

    public static EsbAuthInfo buildAuthentication(BkConfigQueue configQueue, String requestId) {
        Date now = new Date();
        return EsbAuthInfo.builder()
                .srv(configQueue.getSrv())
                .authorizer(configQueue.getHeaderAuthorizer())
                .password(configQueue.getHeaderPassword())
                .req_app(configQueue.getHeaderReqApp())
                .req_id(requestId)
                .req_time(ConverterUtil.toString(now, "dd-MM-yyyy HH:mm:ss.SSS"))
                .build();
    }

    public static String buildUrl(BkConfigQueue configQueue) {
        return configQueue.getHostName() + ":" + configQueue.getPort() + configQueue.getQueueManager();
    }

    public static boolean isSuccess(EsbRespMessage respMessage) {
        return respMessage != null && EsbConstants.ESB_RES_SUCCESS.equals(respMessage.getRespCode());
    }

}
