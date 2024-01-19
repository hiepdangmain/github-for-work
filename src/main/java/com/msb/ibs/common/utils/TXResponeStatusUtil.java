package com.msb.ibs.common.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.msb.ibs.common.dto.DefErrorInfo;
import com.msb.ibs.common.dto.TXResponseCode;
import com.msb.ibs.common.dto.TXStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO: Class description here.
 *
 * @author hainq3
 */
public class TXResponeStatusUtil {

    public TXResponeStatusUtil() {
    }

    public static TXStatus getTXStatusByCode(String code) {
        if (code == null || txStatusMap == null || txStatusMap.size() <= 0)
            return null;
        else
            return (TXStatus) txStatusMap.get(code);
    }

    private static TXResponseCode cloneTXResponseCode(TXResponseCode srcCode) {
        TXResponseCode targetCode = new TXResponseCode();
        BeanUtils.copyProperties(srcCode, targetCode);
        return targetCode;
    }

    private static Map<String, TXStatus> txStatusMap;

    static {
        try {
            Resource resource = new ClassPathResource("TX_def_status.xml");
            InputStream input = resource.getInputStream();

            XmlMapper xmlMapper = new XmlMapper();
            DefErrorInfo defErrorInfo = xmlMapper.readValue(input, DefErrorInfo.class);
            if (defErrorInfo != null) {
                if (!CollectionUtils.isEmpty(defErrorInfo.getTxStatus())) {
                    txStatusMap = defErrorInfo.getTxStatus().stream().collect(Collectors.toMap(TXStatus::getCode, s -> s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}