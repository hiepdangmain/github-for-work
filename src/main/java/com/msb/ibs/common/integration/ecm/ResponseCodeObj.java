/**
 * ResponseCodeObj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.msb.ibs.common.integration.ecm;

import java.lang.reflect.Array;

public class ResponseCodeObj  implements java.io.Serializable {
    private AnyType2AnyTypeMapEntry[][] arrayList;

    private Choice[] choices;

    private String[] data;

    private String message;

    private String responseCode;

    private String url;

    public ResponseCodeObj() {
    }

    public ResponseCodeObj(
           AnyType2AnyTypeMapEntry[][] arrayList,
           Choice[] choices,
           String[] data,
           String message,
           String responseCode,
           String url) {
           this.arrayList = arrayList;
           this.choices = choices;
           this.data = data;
           this.message = message;
           this.responseCode = responseCode;
           this.url = url;
    }


    /**
     * Gets the arrayList value for this ResponseCodeObj.
     * 
     * @return arrayList
     */
    public AnyType2AnyTypeMapEntry[][] getArrayList() {
        return arrayList;
    }


    /**
     * Sets the arrayList value for this ResponseCodeObj.
     * 
     * @param arrayList
     */
    public void setArrayList(AnyType2AnyTypeMapEntry[][] arrayList) {
        this.arrayList = arrayList;
    }


    /**
     * Gets the choices value for this ResponseCodeObj.
     * 
     * @return choices
     */
    public Choice[] getChoices() {
        return choices;
    }


    /**
     * Sets the choices value for this ResponseCodeObj.
     * 
     * @param choices
     */
    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }


    /**
     * Gets the data value for this ResponseCodeObj.
     * 
     * @return data
     */
    public String[] getData() {
        return data;
    }


    /**
     * Sets the data value for this ResponseCodeObj.
     * 
     * @param data
     */
    public void setData(String[] data) {
        this.data = data;
    }


    /**
     * Gets the message value for this ResponseCodeObj.
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this ResponseCodeObj.
     * 
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Gets the responseCode value for this ResponseCodeObj.
     * 
     * @return responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this ResponseCodeObj.
     * 
     * @param responseCode
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the url value for this ResponseCodeObj.
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this ResponseCodeObj.
     * 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ResponseCodeObj)) return false;
        ResponseCodeObj other = (ResponseCodeObj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayList==null && other.getArrayList()==null) || 
             (this.arrayList!=null &&
              java.util.Arrays.equals(this.arrayList, other.getArrayList()))) &&
            ((this.choices==null && other.getChoices()==null) || 
             (this.choices!=null &&
              java.util.Arrays.equals(this.choices, other.getChoices()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              java.util.Arrays.equals(this.data, other.getData()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getArrayList() != null) {
            for (int i=0;
                 i<Array.getLength(getArrayList());
                 i++) {
                Object obj = Array.get(getArrayList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getChoices() != null) {
            for (int i=0;
                 i<Array.getLength(getChoices());
                 i++) {
                Object obj = Array.get(getChoices(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getData() != null) {
            for (int i=0;
                 i<Array.getLength(getData());
                 i++) {
                Object obj = Array.get(getData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseCodeObj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adapter", "ResponseCodeObj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "arrayList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://DefaultNamespace", "anyType2anyTypeMap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://DefaultNamespace", "anyType2anyTypeMap"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("choices");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "choices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://adapter", "Choice"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://adapter", "Choice"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://DefaultNamespace", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adapter", "url"));
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
