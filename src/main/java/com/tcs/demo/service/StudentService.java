package com.tcs.demo.service;

import com.tcs.demo.dto.StudentDto;
import com.tcs.demo.entity.Student;

import java.util.List;

public interface StudentService {
    void save(StudentDto student);
    List<StudentDto> getAllStudents();
}
