package com.msb.ibs.common.integration.ecm;

public class EcmAdapterProxy implements EcmAdapter_PortType {
    private String _endpoint = null;
    private EcmAdapter_PortType ecmAdapter_PortType = null;

    public EcmAdapterProxy() {
        _initEcmAdapterProxy();
    }

    public EcmAdapterProxy(String endpoint) {
        _endpoint = endpoint;
        _initEcmAdapterProxy();
    }

    private void _initEcmAdapterProxy() {
        try {
            ecmAdapter_PortType = (new EcmAdapter_ServiceLocator()).getecmAdapterHttpPort();
            if (ecmAdapter_PortType != null) {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub)ecmAdapter_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
                else
                    _endpoint = (String)((javax.xml.rpc.Stub)ecmAdapter_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
            }

        }
        catch (javax.xml.rpc.ServiceException serviceException) {}
    }

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
        if (ecmAdapter_PortType != null)
            ((javax.xml.rpc.Stub)ecmAdapter_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

    }

    public EcmAdapter_PortType getEcmAdapter_PortType() {
        if (ecmAdapter_PortType == null)
            _initEcmAdapterProxy();
        return ecmAdapter_PortType;
    }

    public ObjDownload downlodFileForECM(java.lang.String in0) throws java.rmi.RemoteException{
        if (ecmAdapter_PortType == null)
            _initEcmAdapterProxy();
        return ecmAdapter_PortType.downlodFileForECM(in0);
    }

    public ResponseCodeObj getChoice(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
        if (ecmAdapter_PortType == null)
            _initEcmAdapterProxy();
        return ecmAdapter_PortType.getChoice(in0, in1);
    }

    public ResponseCodeObj uploadDocument(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, Filedata in6) throws java.rmi.RemoteException{
        if (ecmAdapter_PortType == null)
            _initEcmAdapterProxy();
        return ecmAdapter_PortType.uploadDocument(in0, in1, in2, in3, in4, in5, in6);
    }


}
