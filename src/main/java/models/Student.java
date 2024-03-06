package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "StudentName")
    private StudentName studentName;
    @JacksonXmlProperty(localName = "StudentAddress")
    private StudentAddress studentAddress;

}
