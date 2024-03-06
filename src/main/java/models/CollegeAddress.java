package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CollegeAddress {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "CollegeStreet")
    private String collegeStreet;
    @JacksonXmlProperty(localName = "CollegeNumber")
    private int collegeNumber;
    @JacksonXmlProperty(localName = "CollegeCity")
    private String collegeCity;

}
