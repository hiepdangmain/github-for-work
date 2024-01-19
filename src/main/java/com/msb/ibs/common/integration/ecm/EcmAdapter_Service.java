/**
 * EcmAdapter_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.msb.ibs.common.integration.ecm;

public interface EcmAdapter_Service extends javax.xml.rpc.Service {
    String getecmAdapterHttpPortAddress();

    EcmAdapter_PortType getecmAdapterHttpPort() throws javax.xml.rpc.ServiceException;

    EcmAdapter_PortType getecmAdapterHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
