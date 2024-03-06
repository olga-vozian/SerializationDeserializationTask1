package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CollegeContacts {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "PhoneNumber1")
    private int phoneNumber1;
    @JacksonXmlProperty(localName = "PhoneNumber2")
    private int phoneNumber2;

}
