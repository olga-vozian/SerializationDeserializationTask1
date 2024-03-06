package EmployeeSerializationDeserializationTest;

import models.EmployeeSerializationDeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class EmployeeSerializationDeserializationTest {
    // Create 4-5 Employee objects
    EmployeeSerializationDeserialization olga = new EmployeeSerializationDeserialization("01", "Olga", "IT", 2000,
            LocalDate.of(2021, 1, 18), 34);
    EmployeeSerializationDeserialization mihai = new EmployeeSerializationDeserialization("02", "Mihai", "HR", 3000,
            LocalDate.of(2015, 12, 11), 35);
    EmployeeSerializationDeserialization ion = new EmployeeSerializationDeserialization("03", "Ion", "IT", 2800,
            LocalDate.of(2010, 2, 21), 40);
    EmployeeSerializationDeserialization liubovi = new EmployeeSerializationDeserialization("04", "Liubovi", "Sales", 1500,
            LocalDate.of(2012, 5, 5), 38);
    EmployeeSerializationDeserialization cristina = new EmployeeSerializationDeserialization("05", "Cristina", "Sales", 2300,
            LocalDate.of(2014, 11, 18), 30);

    File file = new File("src/test/resources/EmployeeSerializationDeserialization.txt");

    @org.junit.Test
    public void serializationEmployeeMethodTest() throws IOException {

        // Create 2 streams for objects and save them in a file
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // Save the objects in file
        objectOutputStream.writeObject(olga);
        objectOutputStream.writeObject(mihai);
        objectOutputStream.writeObject(ion);
        objectOutputStream.writeObject(liubovi);
        objectOutputStream.writeObject(cristina);

        // Close the stream and release resources
        objectOutputStream.close();
        assertNotNull(file);
    }


    @org.junit.Test
    public void deserializationEmployeeMethodTest() throws IOException, ClassNotFoundException {

        // Read data from a file that have details of one Employee and deserialize it. Throw exception if data is invalid for mapping to object.
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        models.EmployeeSerializationDeserialization olga = (models.EmployeeSerializationDeserialization) objectInputStream.readObject();

        assertEquals("01", olga.getId());
        assertEquals("Olga", olga.getName());
        assertEquals("IT", olga.getDepartment());
        assertEquals(2000, olga.getSalary());
        assertEquals(LocalDate.of(2021, 1, 18), olga.getJoinDate());
        assertEquals(34, olga.getAge());
    }
}
