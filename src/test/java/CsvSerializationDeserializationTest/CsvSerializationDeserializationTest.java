package CsvSerializationDeserializationTest;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import models.College;
import models.CsvCollege;
import service.XmlUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class CsvSerializationDeserializationTest {

    CsvCollege csvCollege;
    College college;
    XmlUtils xmlUtils = new XmlUtils();
    final CsvMapper csvMapper = new CsvMapper();
    File csvFile = new File("src/test/resources/XmlToCsvSerializationDeserialization.csv");
    File technicalTask = new File("src/main/java/resources/TechnicalTask.xml");

    @org.junit.Test
    public void serializationFromXmlFileToCsvMethodTest() throws IOException {
        csvCollege = changedCollegeObjectToCsvObject();

        // Define scheme CSV for obj. CsvCollege
        CsvSchema schema = csvMapper.schemaFor(CsvCollege.class)
                .withHeader()
                .sortedBy("CollegeName", "CollegeStreet", "CollegeNumber", "CollegeCity", "PhoneNumber1", "PhoneNumber2", "CollegeRank", "FirstName", "LastName",
                        "StreetOfHouse", "NumberOfHouse", "CityHouse");

        // Serialize obj. in file CSV utilizing defined schema
        csvMapper.writer(schema).writeValue(csvFile, csvCollege);

        // Convert obj. csvCollege to String
        String csvString = csvMapper.writer(schema).writeValueAsString(csvCollege);

        //Check if the conversion was performed correctly
        String expectedCsvString = "cityHouse,collegeCity,collegeName,collegeNumber,collegeRank,collegeStreet,firstName,lastName,numberOfHouse," +
                "phoneNumber1,phoneNumber2,streetOfHouse\n" + "Chisinau,Chisinau,\"Centrul de Excelenta in Finante\",22,1,\"Miron Costin\",Elena," +
                "Noroc,55,11223344,55667788,\"Valea Morilor\"\n";

        assertEquals(expectedCsvString, csvString);

    }

    public CsvCollege changedCollegeObjectToCsvObject() throws IOException {
        college = xmlUtils.deserializeXmlFileToCollegeObject(technicalTask);
        CsvCollege csvCollege = new CsvCollege();
        csvCollege.setCollegeName(college.getCollegeName());
        csvCollege.setCollegeStreet(college.getCollegeAddress().getCollegeStreet());
        csvCollege.setCollegeNumber(college.getCollegeAddress().getCollegeNumber());
        csvCollege.setCollegeCity(college.getCollegeAddress().getCollegeCity());
        csvCollege.setPhoneNumber1(college.getCollegeContacts().getPhoneNumber1());
        csvCollege.setPhoneNumber2(college.getCollegeContacts().getPhoneNumber2());
        csvCollege.setCollegeRank(college.getCollegeRank());
        csvCollege.setFirstName(college.getStudent().getStudentName().getFirstName());
        csvCollege.setLastName(college.getStudent().getStudentName().getLastName());
        csvCollege.setStreetOfHouse(college.getStudent().getStudentAddress().getStreetOfHouse());
        csvCollege.setNumberOfHouse(college.getStudent().getStudentAddress().getNumberOfHouse());
        csvCollege.setCityHouse(college.getStudent().getStudentAddress().getCityHouse());
        return csvCollege;

    }


    @org.junit.Test
    public void deserializationCsvMethodTest() throws IOException {

        // Define schema CSV for class CsvCollege
        CsvSchema schema = csvMapper.schemaFor(CsvCollege.class).withHeader().withColumnReordering(true);

        // Deserialization of the CSVFile in a CsvCollege obj.
        MappingIterator<CsvCollege> iterator = csvMapper.readerFor(CsvCollege.class).with(schema).readValues(csvFile);
        while (iterator.hasNext()) {
            CsvCollege csvCollege = iterator.next();

            assertEquals("Centrul de Excelenta in Finante", csvCollege.getCollegeName());
            assertEquals("Miron Costin", csvCollege.getCollegeStreet());
            assertEquals(22, csvCollege.getCollegeNumber());
            assertEquals("Chisinau", csvCollege.getCollegeCity());
            assertEquals(11223344, csvCollege.getPhoneNumber1());
            assertEquals(55667788, csvCollege.getPhoneNumber2());
            assertEquals(1, csvCollege.getCollegeRank());
            assertEquals("Elena", csvCollege.getFirstName());
            assertEquals("Noroc", csvCollege.getLastName());
            assertEquals("Valea Morilor", csvCollege.getStreetOfHouse());
            assertEquals(55, csvCollege.getNumberOfHouse());
            assertEquals("Chisinau", csvCollege.getCityHouse());

        }
    }
}
