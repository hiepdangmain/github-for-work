package com.msb.ibs.common.integration.hsm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import com.msb.ibs.common.utils.JsonUtil;
import org.apache.commons.io.IOUtils;
import vn.mobile_id.trustedhub.clientws.CagCredential;
import vn.mobile_id.trustedhub.clientws.TransactionInfo;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class HsmProcess {
    static final String username = "msb";
    static final String password = "12345678";
    static final String signature = "J7KRqZEdv8Wa/r2ONNgeeVkkT2lV/VkHSjnfwcRJIr1iViX5ZaS/bwDySZX4G67MiXlin6yavwdRmLtDSg2E4NtsDno43Oei2lk487NjsOvU813JrdBWOKNfI/7uAQfn1klMj+UtyRxHFrVGVV6jKGyJtOUE642LacadCKx5mt/p+eSetNTUq+QRwUhOK8lCjAuDR9/aIxUfNSOLId4xDct13sbMfqJkBsuB2iLlWgOoDHAA0oFupYaKNDH/jLSWeRPpT3PqyCdBqc/tmNP0C+XkPXAbWdfZARRmqIouKpSJtFBUHQDBHCOh3tt7eFRSfzcgyMLqQspBgaRNFZJXvg==";
    private static final String p12Pass = "12345678";
    private HsmConnector hsmConnector = new HsmConnector();

    public HsmProcess() {
        super();
    }

    public HsmProcess(HsmConnector hsmConnector) {
        super();
        this.hsmConnector = hsmConnector;
    }

    public String verifySignature(String signedData, String nativeData, String serialCA) {
        try {
            StringBuffer requestBuffer = new StringBuffer("<Channel>MSB</Channel>\n").append("<User>app10</User>\n")
                    .append("<ExternalBillCode>01009090</ExternalBillCode>\n").append("<WorkerName>SignatureValidator</WorkerName>\n")
                    .append("<MetaData>\n")
                    .append("	<SignedData>").append(nativeData).append("</SignedData>\n")
                    .append("	<Encoding>UTF-16LE</Encoding>\n")
                    .append("	<SerialNumber>").append(serialCA).append("</SerialNumber>\n")
                    .append("	<SignatureMethod>TPKI</SignatureMethod>\n")
                    .append("</MetaData>\n")
                    .append("<Signature>").append(signedData).append("</Signature>");

            System.out.println("request: " + requestBuffer.toString());
            TransactionInfo request = new TransactionInfo();
            request.setCredentialData(createCagCredential());
            request.setXmlData(requestBuffer.toString());
            request.setFileData(null);
            TransactionInfo response = hsmConnector.processData(request);
            System.out.println("response: " + response.getXmlData());
            return getResponseCode(response.getXmlData());
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public String verifySignatureFile(File inputFile, MessageLog messageLog) {
        try {
            byte[] fileToSign = IOUtils.toByteArray(new FileInputStream(inputFile));
            StringBuffer requestBuffer = new StringBuffer("<Channel>MSB</Channel>\n").append("<User>app01</User>\n")
                    .append("<ExternalBillCode>010090901</ExternalBillCode>\n").append("<MetaData>\n")
                    .append("	<ExternalStorage>P2P</ExternalStorage>\n").append("</MetaData>\n")
                    .append("<WorkerName>GeneralValidator</WorkerName>\n");
            System.out.println("request: " + requestBuffer.toString());
            messageLog.setRequest(requestBuffer.toString());
            TransactionInfo request = new TransactionInfo();
            request.setCredentialData(createCagCredential());
            request.setXmlData(requestBuffer.toString());
            request.setFileData(fileToSign);
            TransactionInfo response = hsmConnector.processData(request);
            System.out.println(response.getXmlData());
            messageLog.setResponse("response: " + response.getXmlData());
            messageLog.setDateExpired(getDateExpired(response.getXmlData()));
            return getResponseCode(response.getXmlData());
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public byte[] signPDF(byte[] byteData) {
        try {
            System.out.println("chua bi ky");
            StringBuffer requestXMLBuffer = new StringBuffer("<Channel>MSB</Channel>\n").append("<User>app01</User>\n")
                    .append("<ExternalBillCode>210607120101762</ExternalBillCode>\n")
                    .append("<FileType>pdf</FileType>\n").append("<MetaData>\n")
                    .append("<Password>12345678</Password>\n").append("<ExternalStorage>P2P</ExternalStorage>\n")
                    .append("<Method>SynchronousSign</Method>\\n").append("<PageNo>Last</PageNo>\n")
                    .append("<Coordinate>330,10,560,60</Coordinate>\n")
                    .append("<VisibleSignature>True</VisibleSignature>\n")
                    .append("<VisualStatus>True</VisualStatus>\n").append("<ImageAndText>True</ImageAndText>\n")
                    .append("<TextDirection>LEFTTORIGHT</TextDirection>\n")
                    .append("<ShowSignerInfo>True</ShowSignerInfo>\n")
                    .append("<SignerInfoPrefix>Sign by:</SignerInfoPrefix>\n")
                    .append("<ShowDateTime>True</ShowDateTime>\n").append("<DateTimePrefix>Ký ngày:</DateTimePrefix>\n")
                    .append("<TextColor>red</TextColor>\n").append("</MetaData>\n")
                    .append("<WorkerName>MultiSigner</WorkerName>\n");

            System.out.println("requestXMLBuffer: " + requestXMLBuffer);
            System.out.println("chua bi ky 1");
            TransactionInfo request = new TransactionInfo();
            request.setCredentialData(createCagCredential());
            request.setXmlData(requestXMLBuffer.toString());
            request.setFileData(byteData);
            TransactionInfo response = hsmConnector.processData(request);
            System.out.println("chua bi ky 2");
            byte[] daky = response.getFileData();
            if (daky == null) {
                System.out.println("ky fail");
                return byteData;
            } else {
                System.out.println("ky thanh cong");
                return daky;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return byteData;
        }
    }

    public byte[] signPDF(byte[] byteData, String pageNo, String coordinate) {
        try {
            System.out.println("chua bi ky");
            StringBuffer requestXMLBuffer = new StringBuffer("<Channel>MSB</Channel>\n").append("<User>app01</User>\n")
                    .append("<ExternalBillCode>210607120101762</ExternalBillCode>\n")
                    .append("<FileType>pdf</FileType>\n").append("<MetaData>\n")
                    .append("<Password>12345678</Password>\n").append("<ExternalStorage>P2P</ExternalStorage>\n")
                    .append("<Method>SynchronousSign</Method>\\n").append("<PageNo>" + pageNo + "</PageNo>\n")
                    .append("<Coordinate>" + coordinate + "</Coordinate>\n")
                    .append("<VisibleSignature>True</VisibleSignature>\n")
                    .append("<VisualStatus>True</VisualStatus>\n").append("<ImageAndText>True</ImageAndText>\n")
                    .append("<TextDirection>LEFTTORIGHT</TextDirection>\n")
                    .append("<ShowSignerInfo>True</ShowSignerInfo>\n")
                    .append("<SignerInfoPrefix>Sign by:</SignerInfoPrefix>\n")
                    .append("<ShowDateTime>True</ShowDateTime>\n").append("<DateTimePrefix>Ký ngày:</DateTimePrefix>\n")
                    .append("<TextColor>red</TextColor>\n").append("</MetaData>\n")
                    .append("<WorkerName>MultiSigner</WorkerName>\n");

            System.out.println("requestXMLBuffer: " + requestXMLBuffer);
            System.out.println("chua bi ky 1");
            TransactionInfo request = new TransactionInfo();
            request.setCredentialData(createCagCredential());
            request.setXmlData(requestXMLBuffer.toString());
            request.setFileData(byteData);
            TransactionInfo response = hsmConnector.processData(request);
            System.out.println("chua bi ky 2");
            byte[] daky = response.getFileData();
            if (daky == null) {
                System.out.println("ky fail");
                return byteData;
            } else {
                System.out.println("ky thanh cong");
                return daky;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return byteData;
        }
    }

    public byte[] signExcel(byte[] byteData) {
        try {
            StringBuffer requestXMLBuffer = new StringBuffer("<Channel>MSB</Channel>\n").append("<User>app01</User>\n")
                    .append("<ExternalBillCode>210607120101762</ExternalBillCode>\n")
                    .append("<FileType>xlsx</FileType>\n").append("<MetaData>\n")
                    .append("<Password>12345678</Password>\n").append("<ExternalStorage>P2P</ExternalStorage>\n")
                    .append("<Method>SynchronousSign</Method>\\n").append("<PageNo>Last</PageNo>\n")
                    .append("<Coordinate>330,10,560,60</Coordinate>\n")
                    .append("<VisibleSignature>True</VisibleSignature>\n")
                    .append("<VisualStatus>True</VisualStatus>\n").append("<ImageAndText>True</ImageAndText>\n")
                    .append("<TextDirection>LEFTTORIGHT</TextDirection>\n")
                    .append("<ShowSignerInfo>True</ShowSignerInfo>\n")
                    .append("<SignerInfoPrefix>Sign by:</SignerInfoPrefix>\n")
                    .append("<ShowDateTime>True</ShowDateTime>\n").append("<DateTimePrefix>Ký ngày:</DateTimePrefix>\n")
                    .append("<TextColor>red</TextColor>\n").append("</MetaData>\n")
                    .append("<WorkerName>MultiSigner</WorkerName>\n");
            System.out.println("requestXMLBuffer: " + requestXMLBuffer);
            TransactionInfo request = new TransactionInfo();
            request.setCredentialData(createCagCredential());
            request.setXmlData(requestXMLBuffer.toString());
            request.setFileData(byteData);
            TransactionInfo response = hsmConnector.processData(request);
            System.out.println(response.getXmlData());
            byte[] daky = response.getFileData();
            if (daky == null) {
                return byteData;
            } else {
                return daky;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return byteData;
        }
    }

    private CagCredential createCagCredential()
            throws UnrecoverableKeyException, InvalidKeyException, FileNotFoundException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException, SignatureException, IOException {
        String timestamp = String.valueOf(System.currentTimeMillis());
        StringBuffer dataBuffer = new StringBuffer(username).append(password).append(signature).append(timestamp);
        String pkcs1Signature = hsmConnector.getPKCS1Signature(dataBuffer.toString(), p12Pass);
        CagCredential credential = new CagCredential();
        credential.setTimestamp(timestamp);
        credential.setPassword(password);
        credential.setSignature(signature);
        credential.setUsername(username);
        credential.setPkcs1Signature(pkcs1Signature);
        System.out.println("[HsmProcess] createCagCredential: " + JsonUtil.toString(credential));
        return credential;
    }

    private static String getResponseCode(String abc) {
        int begin = abc.indexOf("ResponseCode");
        int end = abc.indexOf("</ResponseCode>");
        return abc.substring(begin + 13, end);
    }

    private static String getDateExpired(String value) {
        int begin = value.indexOf("DateExpired");
        int end = value.indexOf("</DateExpired>");
        if (begin < end) {
            return value.substring(begin + 12, end);
        } else {
            return "";
        }
    }
}
