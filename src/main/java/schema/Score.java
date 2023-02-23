
package schema;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for score complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="score"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="overall" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="very_good" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="good" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="mediocre" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "score")
public class Score {

    @XmlAttribute(name = "unit")
    protected String unit;
    @XmlAttribute(name = "overall")
    protected BigInteger overall;
    @XmlAttribute(name = "very_good")
    protected BigInteger veryGood;
    @XmlAttribute(name = "good")
    protected BigInteger good;
    @XmlAttribute(name = "mediocre")
    protected BigInteger mediocre;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the overall property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOverall() {
        return overall;
    }

    /**
     * Sets the value of the overall property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOverall(BigInteger value) {
        this.overall = value;
    }

    /**
     * Gets the value of the veryGood property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVeryGood() {
        return veryGood;
    }

    /**
     * Sets the value of the veryGood property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVeryGood(BigInteger value) {
        this.veryGood = value;
    }

    /**
     * Gets the value of the good property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGood() {
        return good;
    }

    /**
     * Sets the value of the good property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGood(BigInteger value) {
        this.good = value;
    }

    /**
     * Gets the value of the mediocre property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMediocre() {
        return mediocre;
    }

    /**
     * Sets the value of the mediocre property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMediocre(BigInteger value) {
        this.mediocre = value;
    }

}
