/**
 * ObjDownload.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.msb.ibs.common.integration.ecm;

public class ObjDownload implements java.io.Serializable {
    private Long contentSize;

    private byte[] fileByte;

    private String fileName;

    private String fileType;

    public ObjDownload() {
    }

    public ObjDownload(
           Long contentSize,
           byte[] fileByte,
           String fileName,
           String fileType) {
           this.contentSize = contentSize;
           this.fileByte = fileByte;
           this.fileName = fileName;
           this.fileType = fileType;
    }


    /**
     * Gets the contentSize value for this ObjDownload.
     * 
     * @return contentSize
     */
    public Long getContentSize() {
        return contentSize;
    }


    /**
     * Sets the contentSize value for this ObjDownload.
     * 
     * @param contentSize
     */
    public void setContentSize(Long contentSize) {
        this.contentSize = contentSize;
    }


    /**
     * Gets the fileByte value for this ObjDownload.
     * 
     * @return fileByte
     */
    public byte[] getFileByte() {
        return fileByte;
    }


    /**
     * Sets the fileByte value for this ObjDownload.
     * 
     * @param fileByte
     */
    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }


    /**
     * Gets the fileName value for this ObjDownload.
     * 
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this ObjDownload.
     * 
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the fileType value for this ObjDownload.
     * 
     * @return fileType
     */
    public String getFileType() {
        return fileType;
    }


    /**
     * Sets the fileType value for this ObjDownload.
     * 
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ObjDownload)) return false;
        ObjDownload other = (ObjDownload) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contentSize==null && other.getContentSize()==null) || 
             (this.contentSize!=null &&
              this.contentSize.equals(other.getContentSize()))) &&
            ((this.fileByte==null && other.getFileByte()==null) || 
             (this.fileByte!=null &&
              java.util.Arrays.equals(this.fileByte, other.getFileByte()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.fileType==null && other.getFileType()==null) || 
             (this.fileType!=null &&
              this.fileType.equals(other.getFileType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContentSize() != null) {
            _hashCode += getContentSize().hashCode();
        }
        if (getFileByte() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileByte());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getFileByte(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFileType() != null) {
            _hashCode += getFileType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjDownload.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://download", "ObjDownload"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://download", "contentSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileByte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://download", "fileByte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://download", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://download", "fileType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
