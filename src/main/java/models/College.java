package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "CollegeName")
    private String collegeName;
    @JacksonXmlProperty(localName = "CollegeAddress")
    private CollegeAddress collegeAddress;
    @JacksonXmlProperty(localName = "CollegeContacts")
    private CollegeContacts collegeContacts;
    @JacksonXmlProperty(localName = "CollegeRank")
    private int collegeRank;
    @JacksonXmlProperty(localName = "Student")
    private Student student;

}
