package service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.College;

import java.io.File;
import java.io.IOException;

public class XmlUtils {

    XmlMapper xmlMap = new XmlMapper();

    public College deserializeXmlFileToCollegeObject(File file) throws IOException {
        // Deserialize XML file to College object
        return (College) xmlMap.readValue(file, College.class);
    }

}
