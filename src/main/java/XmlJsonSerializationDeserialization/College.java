package XmlJsonSerializationDeserialization;

import java.util.List;

public class College {
    private static final long serialVersionUID = 1L;
    public String name;
    public String university;
    public Address address;
    public List<String> contacts;
    public Integer rank;

    public College() {

    }

    public College(String name, String university, Address address, List<String> contacts, Integer rank) {
        this.name = name;
        this.university = university;
        this.address = address;
        this.contacts = contacts;
        this.rank = rank;
    }
}
