
package schema;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Element for naming the
 *                 forecast models used, and the respective time
 *                 intervals for each of them.
 *             
 * 
 * <p>Java class for metaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="model" type="{}modelType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="licenseurl" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metaType", propOrder = {
    "model"
})
public class MetaType {

    @XmlElement(required = true)
    protected List<ModelType> model;
    @XmlAttribute(name = "licenseurl")
    @XmlSchemaType(name = "anyURI")
    protected String licenseurl;

    /**
     * Gets the value of the model property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the model property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModelType }
     * 
     * 
     */
    public List<ModelType> getModel() {
        if (model == null) {
            model = new ArrayList<ModelType>();
        }
        return this.model;
    }

    /**
     * Gets the value of the licenseurl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseurl() {
        return licenseurl;
    }

    /**
     * Sets the value of the licenseurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseurl(String value) {
        this.licenseurl = value;
    }

}
