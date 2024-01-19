package com.msb.ibs.common.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.msb.ibs.common.dto.DefErrorInfo;
import com.msb.ibs.common.dto.TXResponseCode;
import com.msb.ibs.common.dto.TXStatus;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;

public class TXResponseCodeUtil {
    private static Map<String, TXResponseCode> responseCodeMap;
    private static Map<String, TXStatus> txStatusMap;

   static {
        try {
            Resource resource = new ClassPathResource("TX_def_error.xml");
            InputStream input = resource.getInputStream();

            XmlMapper xmlMapper = new XmlMapper();
            DefErrorInfo defErrorInfo = xmlMapper.readValue(input, DefErrorInfo.class);
            if (defErrorInfo != null) {
                if (!CollectionUtils.isEmpty(defErrorInfo.getError())) {
                    responseCodeMap = defErrorInfo.getError().stream().collect(Collectors.toMap(TXResponseCode::getCode, s -> s));
                }
                if (!CollectionUtils.isEmpty(defErrorInfo.getTxStatus())) {
                    txStatusMap = defErrorInfo.getTxStatus().stream().collect(Collectors.toMap(TXStatus::getCode, s -> s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static TXResponseCode getTXResponseCodeByCode(String code) {
        if (!CollectionUtils.isEmpty(responseCodeMap)) {
            TXResponseCode txResponseCode = responseCodeMap.get(code);
            if (txResponseCode != null) {
                return txResponseCode;
            }
        }
        return responseCodeMap.get("-99");
    }


	public static String getTXResponseMessageByCode(String code, String lang) {
		TXResponseCode txResponseCode = getTXResponseCodeByCode(code);
		String message = "";
		if (txResponseCode != null) {
			message = "vi".equalsIgnoreCase(lang) || lang == null ? txResponseCode.getDisplayName() : txResponseCode.getDisplayNameEng();
		}
		return message;
	}

    public static String getTXResponseMessage(TXResponseCode txResponseCode, String lang) {
        return "vi".equalsIgnoreCase(lang) || lang == null ? txResponseCode.getDisplayName() : txResponseCode.getDisplayNameEng();
    }

	public static TXStatus getTXStatusByStatus(String status) {
         if (!CollectionUtils.isEmpty(txStatusMap)) {
             return txStatusMap.get(status);
         }
		return null;
	}

    public static String getTXStatusMessageByStatus(String status, String lang) {
        TXStatus txStatus = getTXStatusByStatus(status);
        String message = "";
        if (txStatus != null) {
            message = "vi".equalsIgnoreCase(lang) || lang == null ? txStatus.getDisplayName() : txStatus.getDisplayNameEng();
        }
        return message;
    }
}