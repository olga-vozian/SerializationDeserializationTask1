package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentAddress {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "StreetOfHouse")
    private String streetOfHouse;
    @JacksonXmlProperty(localName = "NumberOfHouse")
    private int numberOfHouse;
    @JacksonXmlProperty(localName = "CityHouse")
    private String cityHouse;

}
