/**
 * UploadDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.msb.ibs.common.integration.ecm;

public class UploadDocument  implements java.io.Serializable {
    private String in0;

    private String in1;

    private String in2;

    private String in3;

    private String in4;

    private String in5;

    private Filedata in6;

    public UploadDocument() {
    }

    public UploadDocument(
           String in0,
           String in1,
           String in2,
           String in3,
           String in4,
           String in5,
           Filedata in6) {
           this.in0 = in0;
           this.in1 = in1;
           this.in2 = in2;
           this.in3 = in3;
           this.in4 = in4;
           this.in5 = in5;
           this.in6 = in6;
    }


    /**
     * Gets the in0 value for this UploadDocument.
     * 
     * @return in0
     */
    public String getIn0() {
        return in0;
    }


    /**
     * Sets the in0 value for this UploadDocument.
     * 
     * @param in0
     */
    public void setIn0(String in0) {
        this.in0 = in0;
    }


    /**
     * Gets the in1 value for this UploadDocument.
     * 
     * @return in1
     */
    public String getIn1() {
        return in1;
    }


    /**
     * Sets the in1 value for this UploadDocument.
     * 
     * @param in1
     */
    public void setIn1(String in1) {
        this.in1 = in1;
    }


    /**
     * Gets the in2 value for this UploadDocument.
     * 
     * @return in2
     */
    public String getIn2() {
        return in2;
    }


    /**
     * Sets the in2 value for this UploadDocument.
     * 
     * @param in2
     */
    public void setIn2(String in2) {
        this.in2 = in2;
    }


    /**
     * Gets the in3 value for this UploadDocument.
     * 
     * @return in3
     */
    public String getIn3() {
        return in3;
    }


    /**
     * Sets the in3 value for this UploadDocument.
     * 
     * @param in3
     */
    public void setIn3(String in3) {
        this.in3 = in3;
    }


    /**
     * Gets the in4 value for this UploadDocument.
     * 
     * @return in4
     */
    public String getIn4() {
        return in4;
    }


    /**
     * Sets the in4 value for this UploadDocument.
     * 
     * @param in4
     */
    public void setIn4(String in4) {
        this.in4 = in4;
    }


    /**
     * Gets the in5 value for this UploadDocument.
     * 
     * @return in5
     */
    public String getIn5() {
        return in5;
    }


    /**
     * Sets the in5 value for this UploadDocument.
     * 
     * @param in5
     */
    public void setIn5(String in5) {
        this.in5 = in5;
    }


    /**
     * Gets the in6 value for this UploadDocument.
     * 
     * @return in6
     */
    public Filedata getIn6() {
        return in6;
    }


    /**
     * Sets the in6 value for this UploadDocument.
     * 
     * @param in6
     */
    public void setIn6(Filedata in6) {
        this.in6 = in6;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UploadDocument)) return false;
        UploadDocument other = (UploadDocument) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.in0==null && other.getIn0()==null) || 
             (this.in0!=null &&
              this.in0.equals(other.getIn0()))) &&
            ((this.in1==null && other.getIn1()==null) || 
             (this.in1!=null &&
              this.in1.equals(other.getIn1()))) &&
            ((this.in2==null && other.getIn2()==null) || 
             (this.in2!=null &&
              this.in2.equals(other.getIn2()))) &&
            ((this.in3==null && other.getIn3()==null) || 
             (this.in3!=null &&
              this.in3.equals(other.getIn3()))) &&
            ((this.in4==null && other.getIn4()==null) || 
             (this.in4!=null &&
              this.in4.equals(other.getIn4()))) &&
            ((this.in5==null && other.getIn5()==null) || 
             (this.in5!=null &&
              this.in5.equals(other.getIn5()))) &&
            ((this.in6==null && other.getIn6()==null) || 
             (this.in6!=null &&
              this.in6.equals(other.getIn6())));
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
        if (getIn0() != null) {
            _hashCode += getIn0().hashCode();
        }
        if (getIn1() != null) {
            _hashCode += getIn1().hashCode();
        }
        if (getIn2() != null) {
            _hashCode += getIn2().hashCode();
        }
        if (getIn3() != null) {
            _hashCode += getIn3().hashCode();
        }
        if (getIn4() != null) {
            _hashCode += getIn4().hashCode();
        }
        if (getIn5() != null) {
            _hashCode += getIn5().hashCode();
        }
        if (getIn6() != null) {
            _hashCode += getIn6().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UploadDocument.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://DefaultNamespace", ">UploadDocument"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in0");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in0"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("in6");
        elemField.setXmlName(new javax.xml.namespace.QName("http://DefaultNamespace", "in6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://adapter", "Filedata"));
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
