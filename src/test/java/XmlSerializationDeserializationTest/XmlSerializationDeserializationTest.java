package XmlSerializationDeserializationTest;

import XmlJsonSerializationDeserialization.Address;
import XmlJsonSerializationDeserialization.College;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlSerializationDeserializationTest {
    XmlMapper xmlMap = new XmlMapper();
    File file = new File("src/test/resources/XmlSerializationDeserializationCollege.xml");

    @org.junit.Test
    public void serializationXmlMethodTest() throws IOException {
        List<String> contacts = new ArrayList<>(Arrays.asList("11223344", "55667788"));
        College college = new College("Centrul de Excelenta in Finante", "Universitatea de Stat",
                new Address("Miron Costin", 22, "Chisinau"), contacts, 1);
        xmlMap.writeValue(file, college);

        // Conversion of College obj. in XML string
        String xmlString = xmlMap.writeValueAsString(college);

        // Check if the conversion was performed correctly
        String expectedXmlString = new String(Files.readAllBytes(Paths.get("src/test/resources/XmlSerializationDeserializationCollege.xml")));
        assertEquals(expectedXmlString, xmlString);
    }


    @org.junit.Test
    public void deserializeXmlMethodTest() throws IOException {
        // Deserialize College obj. from XML file
        College college = xmlMap.readValue(file, College.class);

        // Check the value of the deserialized obj.
        assertEquals("Centrul de Excelenta in Finante", college.name);
        assertEquals("Universitatea de Stat", college.university);
        assertEquals("Miron Costin", college.address.street);
        assertEquals(Integer.valueOf(22), college.address.number);
        assertEquals("Chisinau", college.address.city);
        assertEquals(2, college.contacts.size());
        assertEquals("11223344", college.contacts.get(0));
        assertEquals("55667788", college.contacts.get(1));
        assertEquals(Integer.valueOf(1), college.rank);
    }
}
