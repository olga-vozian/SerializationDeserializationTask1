package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeSerializationDeserialization implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String department;
    private int salary;
    private LocalDate joinDate;
    private int age;

}
