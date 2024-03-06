package XmlSerializationDeserializationTest;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.College;
import service.XmlUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class XmlSerializationDeserializationTest {
    College college;
    XmlMapper xmlMap = new XmlMapper();
    final XmlUtils xmlUtils = new XmlUtils();
    File file = new File("src/test/resources/XmlSerializationDeserialization.xml");
    File technicalTask = new File("src/main/java/resources/TechnicalTask.xml");

    @org.junit.Test
    public void serializationXmlMethodTest() throws IOException {
        college = xmlUtils.deserializeXmlFileToCollegeObject(technicalTask);
        xmlMap.writeValue(file, college);

        // Conversion of College obj. in XML String
        String xmlString = xmlMap.writeValueAsString(college);

        // Check if the conversion was performed correctly
        String expectedXmlString = new String(Files.readAllBytes(Paths.get("src/main/java/resources/TechnicalTask.xml")));
        assertEquals(expectedXmlString, xmlString);

    }


    @org.junit.Test
    public void deserializeXmlMethodTest() throws IOException {
        // Deserialization of the XmlFile in a College obj.
        college = xmlUtils.deserializeXmlFileToCollegeObject(technicalTask);

        assertEquals("Centrul de Excelenta in Finante", college.getCollegeName());
        assertEquals("Miron Costin", college.getCollegeAddress().getCollegeStreet());
        assertEquals(22, college.getCollegeAddress().getCollegeNumber());
        assertEquals("Chisinau", college.getCollegeAddress().getCollegeCity());
        assertEquals(11223344, college.getCollegeContacts().getPhoneNumber1());
        assertEquals(55667788, college.getCollegeContacts().getPhoneNumber2());
        assertEquals(1, college.getCollegeRank());
        assertEquals("Elena", college.getStudent().getStudentName().getFirstName());
        assertEquals("Noroc", college.getStudent().getStudentName().getLastName());
        assertEquals("Valea Morilor", college.getStudent().getStudentAddress().getStreetOfHouse());
        assertEquals(55, college.getStudent().getStudentAddress().getNumberOfHouse());
        assertEquals("Chisinau", college.getStudent().getStudentAddress().getCityHouse());

    }
}
