package com.msb.ibs.common.integration.hsm;

import com.msb.ibs.common.constant.HsmConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import vn.mobile_id.trustedhub.clientws.ClientWS;
import vn.mobile_id.trustedhub.clientws.ClientWSService;
import vn.mobile_id.trustedhub.clientws.TransactionInfo;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.namespace.QName;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Enumeration;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HsmConnector {
    private String hsmUrl;

    public TransactionInfo processData(TransactionInfo transactionInfo) {
        System.out.println("hsmUrl: " + hsmUrl);
        ClientWS ws;
        TransactionInfo transRes = new TransactionInfo();
        try {
            ws = getWS();
            transRes = ws.processData(transactionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transRes;
    }

    private ClientWS getWS() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };

        // Install the all-trusting trust manager
        SSLContext sc;
        try {
            sc = SSLContext.getInstance(HsmConstants.WS_SSL_INSTANCE);
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception ex) {

        }

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

        ClientWSService service = new ClientWSService(new URL(hsmUrl),
                new QName(HsmConstants.WS_URI, HsmConstants.WS_LOCAL_PART));
        return service.getClientWSPort();
    }

    public String getPKCS1Signature(String data, String p12Pass)
            throws KeyStoreException, IOException, NoSuchAlgorithmException,
            CertificateException, UnrecoverableKeyException, SignatureException, InvalidKeyException {

        Resource resource = new ClassPathResource(HsmConstants.KEY_PATH);
        Security.addProvider(new BouncyCastleProvider());
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        InputStream is = resource.getInputStream();
        keystore.load(is, p12Pass.toCharArray());

        Enumeration<String> e = keystore.aliases();
        String aliasName = "";
        PrivateKey key = null;
        while (e.hasMoreElements()) {
            aliasName = e.nextElement();
            key = (PrivateKey) keystore.getKey(aliasName, p12Pass.toCharArray());
            if (key != null) {
                break;
            }
        }

        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initSign(key);
        sig.update(data.getBytes());

        return Base64.getEncoder().encodeToString(sig.sign());
    }
}
