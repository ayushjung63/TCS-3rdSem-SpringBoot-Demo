package com.tcs.demo.controller;

import com.tcs.demo.dto.StudentDto;
import com.tcs.demo.service.StudentService;
import com.tcs.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/save", method = RequestMethod.POST)
    public String save(@RequestBody StudentDto dto) {
        studentService.save(dto);
        return "Success";
    }

    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentList = studentService.getAllStudents();
        return studentList;
    }

   /* @RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentRepo.deleteById(studentId);
        return "Success";
    }

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
    public Student getById(@PathVariable("studentId") Integer studentId) {
        Optional<Student> studentOptional = studentRepo.findById(studentId);
        if (studentOptional.isPresent()) {
            Student s1 = studentOptional.get();
            return s1;
        }
        throw new RuntimeException("Student not found with id " + studentId);
    }*/

}
