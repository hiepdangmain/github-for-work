package com.msb.ibs.common.integration.ecm;

public class EcmAdapter_ServiceLocator extends org.apache.axis.client.Service implements EcmAdapter_Service {

    public EcmAdapter_ServiceLocator() {
    }


    public EcmAdapter_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EcmAdapter_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ecmAdapterHttpPort
    private String ecmAdapterHttpPort_address = "http://10.1.66.108:9080/ecm/services/ecmAdapter";

    public String getecmAdapterHttpPortAddress() {
        return ecmAdapterHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String ecmAdapterHttpPortWSDDServiceName = "ecmAdapterHttpPort";

    public String getecmAdapterHttpPortWSDDServiceName() {
        return ecmAdapterHttpPortWSDDServiceName;
    }

    public void setecmAdapterHttpPortWSDDServiceName(String name) {
        ecmAdapterHttpPortWSDDServiceName = name;
    }

    public EcmAdapter_PortType getecmAdapterHttpPort() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ecmAdapterHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getecmAdapterHttpPort(endpoint);
    }

    public EcmAdapter_PortType getecmAdapterHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            EcmAdapterHttpBindingStub _stub = new EcmAdapterHttpBindingStub(portAddress, this);
            _stub.setPortName(getecmAdapterHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setecmAdapterHttpPortEndpointAddress(String address) {
        ecmAdapterHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (EcmAdapter_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                EcmAdapterHttpBindingStub _stub = new EcmAdapterHttpBindingStub(new java.net.URL(ecmAdapterHttpPort_address), this);
                _stub.setPortName(getecmAdapterHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("ecmAdapterHttpPort".equals(inputPortName)) {
            return getecmAdapterHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "ecmAdapter");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "ecmAdapterHttpPort"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

        if ("ecmAdapterHttpPort".equals(portName)) {
            setecmAdapterHttpPortEndpointAddress(address);
        }
        else
        { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}