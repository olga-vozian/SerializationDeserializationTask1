package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CsvCollege {

    private static final long serialVersionUID = 1L;

    private String collegeName;
    private String collegeStreet;
    private int collegeNumber;
    private String collegeCity;
    private int phoneNumber1;
    private int phoneNumber2;
    private int collegeRank;
    private String firstName;
    private String lastName;
    private String streetOfHouse;
    private int numberOfHouse;
    private String cityHouse;

}
