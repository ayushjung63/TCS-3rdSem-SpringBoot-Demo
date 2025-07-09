package com.tcs.demo.dto;

public class StudentDto {
    private Integer id;
    private String name;
    private String section;
    private String facultyName;
    private Integer facultyId;

    public StudentDto(Integer id, String name, String section, String facultyName,Integer facultyId) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.facultyName = facultyName;
        this.facultyId=facultyId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
