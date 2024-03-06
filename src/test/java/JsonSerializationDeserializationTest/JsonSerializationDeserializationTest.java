package JsonSerializationDeserializationTest;

import XmlJsonSerializationDeserialization.Address;
import XmlJsonSerializationDeserialization.College;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonSerializationDeserializationTest {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("src/test/resources/JsonSerializationDeserializationCollege.json");

    @org.junit.Test
    public void serializationJsonMethodTest() throws IOException {
        List<String> contacts = new ArrayList<>(Arrays.asList("11223344", "55667788"));
        Address address = new Address("Miron Costin", 22, "Chisinau");
        College college =  new College("Centrul de Excelenta in Finante", "Universitatea de Stat", address, contacts, 1);
        objectMapper.writeValue(file, college);
        assertNotNull(file);

        // Convert obj. College in a sequence of characters String
        String jsonString = objectMapper.writeValueAsString(college);

        // Check if the conversion was performed correctly
        String expectedJsonString = "{\"name\":\"Centrul de Excelenta in Finante\",\"university\":\"Universitatea de Stat\",\"address\":{\"street\":" +
                "\"Miron Costin\",\"number\":22,\"city\":\"Chisinau\"},\"contacts\":[\"11223344\",\"55667788\"],\"rank\":1}";
        assertEquals(expectedJsonString, jsonString);
    }


    @org.junit.Test
    public void deserializeJsonMethodTest() throws IOException {
        // Deserialize obj. College from Json file
        College college = objectMapper.readValue(file, College.class);

        // Check the value of the deserialized object
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
