/**
 * Filedata.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.msb.ibs.common.integration.ecm;

public class Filedata  implements java.io.Serializable {
    private byte[] bt;

    private String fileName;

    private String fileObjectInString;

    public Filedata() {
    }

    public Filedata(
           byte[] bt,
           String fileName,
           String fileObjectInString) {
           this.bt = bt;
           this.fileName = fileName;
           this.fileObjectInString = fileObjectInString;
    }


    /**
     * Gets the bt value for this Filedata.
     * 
     * @return bt
     */
    public byte[] getBt() {
        return bt;
    }


    /**
     * Sets the bt value for this Filedata.
     * 
     * @param bt
     */
    public void setBt(byte[] bt) {
        this.bt = bt;
    }


    /**
     * Gets the fileName value for this Filedata.
     * 
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this Filedata.
     * 
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the fileObjectInString value for this Filedata.
     * 
     * @return fileObjectInString
     */
    public String getFileObjectInString() {
        return fileObjectInString;
    }


    /**
     * Sets the fileObjectInString value for this Filedata.
     * 
     * @param fileObjectInString
     */
    public void setFileObjectInString(String fileObjectInString) {
        this.fileObjectInString = fileObjectInString;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Filedata)) return false;
        Filedata other = (Filedata) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bt==null && other.getBt()==null) || 
             (this.bt!=null &&
              java.util.Arrays.equals(this.bt, other.getBt()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.fileObjectInString==null && other.getFileObjectInString()==null) || 
             (this.fileObjectInString!=null &&
              this.fileObjectInString.equals(other.getFileObjectInString())));
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
        if (getBt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBt());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getBt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFileObjectInString() != null) {
            _hashCode += getFileObjectInString().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Filedata.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adapter", "Filedata"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "bt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileObjectInString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "fileObjectInString"));
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
