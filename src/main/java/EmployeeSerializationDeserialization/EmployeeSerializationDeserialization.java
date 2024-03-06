package EmployeeSerializationDeserialization;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeSerializationDeserialization implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String department;
    private int salary;
    private LocalDate joinDate;
    private int age;


    public EmployeeSerializationDeserialization(String id, String name, String department, int salary, LocalDate joinDate, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
