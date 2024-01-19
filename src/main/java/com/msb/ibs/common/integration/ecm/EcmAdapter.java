package com.msb.ibs.common.integration.ecm;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

public class EcmAdapter {
    private static final Log LOGGER = LogFactory.getLog(EcmAdapter.class);

    public EcmResponse uploadFile(String urlECM, UploadFile uploadFile) {
        LOGGER.info("Begin Upload File To ECM for CIF:" + uploadFile.getCif());
        LOGGER.info(" EcmAdapter getChanel:" + uploadFile.getChanel());
        LOGGER.info(" EcmAdapter getProjectID:" + uploadFile.getProjectID());
        LOGGER.info(" EcmAdapter getCif:" + uploadFile.getCif());
        LOGGER.info(" EcmAdapter getRootFolder:" + uploadFile.getRootFolder());
        LOGGER.info(" EcmAdapter getFolderName:" + uploadFile.getFolderName());
        LOGGER.info(" EcmAdapter getFileName:" + uploadFile.getFileName());
        long start = System.currentTimeMillis();

        EcmResponse ecmResponse = new EcmResponse();
        RespMessage respMessage = new RespMessage();
        Map<String, Object> respDomain = new LinkedHashMap<>();
        UploadFileResponse uploadFileResponse = new UploadFileResponse();

        try {
            EcmAdapterProxy adapterProxy = new EcmAdapterProxy();
            ResponseCodeObj codeObj = new ResponseCodeObj();
            adapterProxy.setEndpoint(urlECM);
            uploadFile.setChanel(uploadFile.getChanel());
            uploadFile.setFolderName(uploadFile.getFolderName());

            Filedata filedata = new Filedata();
            filedata.setBt(uploadFile.getByteData());
            filedata.setFileName(uploadFile.getDoccumentTitle());
            codeObj = adapterProxy.uploadDocument(uploadFile.getChanel(), uploadFile.getProjectID(), uploadFile.getCif(),
                    uploadFile.getRootFolder(), uploadFile.getFolderName(), uploadFile.getFileName(),
                    filedata);

            respMessage.setRespCode(codeObj.getResponseCode());
            respMessage.setRespDesc(codeObj.getMessage());
            if("FNT_000".equals(codeObj.getResponseCode())) {
                respMessage.setRespCode("0");
            }
            LOGGER.info(" EcmAdapter setRespCode:" + codeObj.getResponseCode());
            LOGGER.info(" EcmAdapter setRespDesc:" + codeObj.getMessage());

            respDomain.put("data", codeObj.getData());
            uploadFileResponse.setRespMessage(respMessage);
            uploadFileResponse.setRespDomain(respDomain);
            ecmResponse.setUploadFileResponse(uploadFileResponse);

        } catch (Exception e) {
            System.out.println(" EcmAdapter ERROR");
            e.printStackTrace();
        }
        long end = System.currentTimeMillis() - start;
        LOGGER.info("End Upload File To ECM TotalTime:" + end);
        return ecmResponse;
    }

    public EcmResponse downloadFile(String urlECM, DownloadFile downloadFile) throws JsonProcessingException {
        EcmResponse requestReplyBean = new EcmResponse();
        EcmAdapterProxy adapterProxy = new EcmAdapterProxy();
        ObjDownload objDownload = new ObjDownload();
        RespMessage respMessage = new RespMessage();
        Map<String, Object> respDomain = new LinkedHashMap<>();
        DownloadFileResponse downloadFileResponse = new DownloadFileResponse();
        try {
            adapterProxy.setEndpoint(urlECM);

            objDownload = adapterProxy.downlodFileForECM(downloadFile.getDocumentID());

            if (objDownload.getFileByte() != null) {
                respMessage.setRespCode("0");
                respMessage.setRespDesc("Transaction is Successfull");
            } else {
                respMessage.setRespCode("1");
                respMessage.setRespDesc("Transaction is fail");
            }

            respDomain.put("fileByte", objDownload.getFileByte());
            respDomain.put("fileName", objDownload.getFileName());
            downloadFileResponse.setRespMessage(respMessage);
            downloadFileResponse.setRespDomain(respDomain);
            requestReplyBean.setDownloadFileResponse(downloadFileResponse);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return requestReplyBean;
    }

}

