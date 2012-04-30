//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.28 at 02:33:06 PM CEST 
//

package org.apache.cxf.fediz.core.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * This structure contains the specification of JSSE TrustManagers for a single
 * Keystore used for trusted certificates.
 * 
 * 
 * <p>
 * Java class for TrustManagersType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TrustManagersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="keyStore" type="{}KeyStoreType" minOccurs="0"/>
 *         &lt;element name="certStore" type="{}CertStoreType" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="provider" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="factoryAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrustManagersType", propOrder = { "keyStore", "certStore" })
public class TrustManagersType {

    protected KeyStoreType keyStore;
    protected CertStoreType certStore;
    @XmlAttribute(name = "provider")
    protected String provider;
    @XmlAttribute(name = "factoryAlgorithm")
    protected String factoryAlgorithm;

    /**
     * Gets the value of the keyStore property.
     * 
     * @return possible object is {@link KeyStoreType }
     * 
     */
    public KeyStoreType getKeyStore() {
        return keyStore;
    }

    /**
     * Sets the value of the keyStore property.
     * 
     * @param value
     *            allowed object is {@link KeyStoreType }
     * 
     */
    public void setKeyStore(KeyStoreType value) {
        this.keyStore = value;
    }

    /**
     * Gets the value of the certStore property.
     * 
     * @return possible object is {@link CertStoreType }
     * 
     */
    public CertStoreType getCertStore() {
        return certStore;
    }

    /**
     * Sets the value of the certStore property.
     * 
     * @param value
     *            allowed object is {@link CertStoreType }
     * 
     */
    public void setCertStore(CertStoreType value) {
        this.certStore = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setProvider(String value) {
        this.provider = value;
    }

    /**
     * Gets the value of the factoryAlgorithm property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFactoryAlgorithm() {
        return factoryAlgorithm;
    }

    /**
     * Sets the value of the factoryAlgorithm property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setFactoryAlgorithm(String value) {
        this.factoryAlgorithm = value;
    }

}