package com.msb.ibs.common.integration.minio;

import lombok.Builder;
import lombok.Data;

@Data
public class FileInput {
    private String filePath;
    private byte[] content;
    private String bucket;
    private String defaultBaseFolder;
    private String name;
    private String object;
    private String mimeType;
}
