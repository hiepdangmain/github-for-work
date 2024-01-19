package com.msb.ibs.common.integration.ecm;

public interface EcmAdapter_PortType extends java.rmi.Remote {
    ObjDownload downlodFileForECM(String in0) throws java.rmi.RemoteException;
    ResponseCodeObj getChoice(String in0, String in1) throws java.rmi.RemoteException;
    ResponseCodeObj uploadDocument(String in0, String in1, String in2, String in3, String in4, String in5, Filedata in6) throws java.rmi.RemoteException;
}
