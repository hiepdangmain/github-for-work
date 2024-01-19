package com.msb.ibs.common.integration.minio;

import io.minio.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MinIOAdapter {

    private static final Logger logger = LoggerFactory.getLogger(MinIOAdapter.class);

    public MinioClient generateMinioClient(String minioUrl, String accessKey, String secretKey) {
        try {
            return MinioClient.builder()
                    .endpoint(minioUrl)
                    .credentials(accessKey, secretKey)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean uploadFile(MinioClient minioClient, FileInput input){
        try {
            InputStream fis = new ByteArrayInputStream(input.getContent());
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(input.getBucket())
                    .object(input.getDefaultBaseFolder() + input.getName())
                    .stream(new BufferedInputStream(fis), fis.available(),-1)
                    .contentType(input.getMimeType())
                    .build());
            logger.info("File {} is successfully uploaded as object {} to bucket {}",
                    input.getFilePath(), input.getDefaultBaseFolder() + input.getName(), input.getBucket());
            return true;
        } catch (Exception e) {
            logger.error("Error uploadFile: {}", e);
        }
        return false;
    }

    public byte[] downloadFile(MinioClient minioClient, FileInput input) {
        try {
            InputStream obj = minioClient.getObject(GetObjectArgs.builder()
                    .bucket(input.getBucket())
                    .object(input.getObject())
                    .build());

            byte[] content = IOUtils.toByteArray(obj);
            obj.close();
            return content;
        } catch (Exception e) {
            logger.error("Error downloadFile: {}", e);
        }
        return null;
    }

    public boolean deleteFile(MinioClient minioClient, String bucket, List<String> objects) {
        try {
            logger.info("Start delete objects {}", objects);
            List<DeleteObject> delObjects = new LinkedList<>();
            for (String object : objects) {
                delObjects.add(new DeleteObject(object));
            }
            Iterable<Result<DeleteError>> results =
                    minioClient.removeObjects(
                            RemoveObjectsArgs.builder().bucket(bucket).objects(delObjects).build());
            for (Result<DeleteError> result : results) {
                DeleteError error = result.get();
                logger.info("Error in deleting object " + error.objectName() + "; " + error.message());
            }
            logger.info("Done delete objects {}", objects);
            return true;
        } catch (Exception e) {
            logger.error("Error deleteFile: {}", e);
        }
        return false;
    }
}
