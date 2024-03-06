package JsonSerializationDeserializationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.College;
import service.XmlUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonSerializationDeserializationTest {
    College college;
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("src/test/resources/XmlToJsonSerializationDeserialization.json");
    File technicalTask = new File("src/main/java/resources/TechnicalTask.xml");
    final XmlUtils xmlUtils = new XmlUtils();

    @org.junit.Test
    public void serializationFromXmlToJsonMethodTest() throws IOException {
        college = xmlUtils.deserializeXmlFileToCollegeObject(technicalTask);
        objectMapper.writeValue(file, college);

        // Convert obj. College in a sequence of characters String
        String jsonString = objectMapper.writeValueAsString(college);

        // Check if the conversion was performed correctly
        String expectedJsonString = "{\"collegeName\":\"Centrul de Excelenta in Finante\",\"collegeAddress\":{\"collegeStreet\":\"Miron Costin\",\"collegeNumber\":22," +
                "\"collegeCity\":\"Chisinau\"},\"collegeContacts\":{\"phoneNumber1\":11223344,\"phoneNumber2\":55667788},\"collegeRank\":1,\"student\":{\"studentName\":" +
                "{\"firstName\":\"Elena\",\"lastName\":\"Noroc\"},\"studentAddress\":{\"streetOfHouse\":\"Valea Morilor\",\"numberOfHouse\":55,\"cityHouse\":\"Chisinau\"}}}";
        assertEquals(expectedJsonString, jsonString);

    }


    @org.junit.Test
    public void deserializeJsonMethodTest() throws IOException {
        // Deserialization of the JsonFile in a College obj.
        College college = objectMapper.readValue(file, College.class);

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
