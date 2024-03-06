package CsvSerializationDeserializationTest;

import CsvSerializationDeserialization.CsvAddress;
import CsvSerializationDeserialization.CsvCollege;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CsvSerializationDeserializationTest {
    CsvMapper mapper = new CsvMapper();
    File file = new File("src/test/resources/CsvSerializationDeserializationCollege.csv");

    @org.junit.Test
    public void serializationCsvMethodTest() throws IOException {
        // Create a new obj. CsvCollege with a nested obj. CsvAddress and a list of contacts
        CsvAddress address = new CsvAddress("Miron Costin", 26, "Chisinau");
        List<String> contacts = Arrays.asList("11223344", "55667788");
        CsvCollege college = new CsvCollege("Centrul de Excelenta in Finante", "Universitatea de Stat", address.street, address.number, address.city,
                contacts, 2);

        // Define scheme CSV for obj. CsvCollege
        CsvSchema schema = mapper.schemaFor(CsvCollege.class)
                .withHeader()
                .sortedBy("name", "university", "street", "number", "city", "contacts", "rank");

        // Serialize obj. in file CSV utilizing defined schema
        mapper.writer(schema).writeValue(file, college);

        // Convert obj. College to String
        String csvString = mapper.writer(schema).writeValueAsString(college);

        // Check if the conversion was performed correctly
        String expectedCsvString = "name,university,street,number,city,contacts,rank\n" +
                "\"Centrul de Excelenta in Finante\",\"Universitatea de Stat\",\"Miron Costin\",26,Chisinau,11223344;55667788,2\n";
        assertEquals(expectedCsvString, csvString);
    }


    @org.junit.Test
    public void deserializationCsvMethodTest() throws IOException {
        // Define schema CSV for class CsvCollege
        CsvSchema schema = mapper.schemaFor(CsvCollege.class).withHeader().withColumnReordering(true);

        // Deserialization of the file CSV in a CsvCollege obj.
        MappingIterator<CsvCollege> iterator = mapper.readerFor(CsvCollege.class).with(schema).readValues(file);
        while (iterator.hasNext()) {
            CsvCollege college = iterator.next();

            assertEquals("Centrul de Excelenta in Finante", college.name);
            assertEquals("Universitatea de Stat", college.university);
            assertEquals("Miron Costin", college.street);
            assertEquals(Integer.valueOf(26), college.number);
            assertEquals("Chisinau", college.city);
            assertEquals(Integer.valueOf(2), college.rank);
        }
    }
}
