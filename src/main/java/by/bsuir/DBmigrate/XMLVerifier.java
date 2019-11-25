package by.bsuir.DBmigrate;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * The type Xml verifier.
 */
public class XMLVerifier {

    /**
     * Validate boolean.
     *
     * @param xml the xml
     * @param xsd the xsd
     * @return the boolean
     */
    public boolean validate(File xml, File xsd)
    {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
