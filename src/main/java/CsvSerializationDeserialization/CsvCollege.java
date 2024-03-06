package CsvSerializationDeserialization;

import java.util.List;

public class CsvCollege {
    private static final long serialVersionUID = 1L;
    public String name;
    public String university;
    public String street;
    public Integer number;
    public String city;
    public List<String> contacts;
    public Integer rank;

    public CsvCollege() {

    }

    public CsvCollege(String name, String university, String street, Integer number, String city, List<String> contacts, Integer rank) {
        this.name = name;
        this.university = university;
        this.street = street;
        this.number = number;
        this.city = city;
        this.contacts = contacts;
        this.rank = rank;
    }
}
