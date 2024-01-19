package com.msb.ibs.common.request;

import com.msb.ibs.common.dto.AttachmentDto;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class InputSendMailData {
    private String templateCode;
    private String mailType;
    private String toAddress;
    private String ccAddress;
    private String bccAddress;
    private List<Integer> listUserId;
    private List<Integer> roleAdminIds;
    private Map<String, Object> params;
    private List<AttachmentDto> attachments;
    private String tranSn;
    private String serviceType;
}
