package com.tcs.demo.controller;

import com.tcs.demo.StudentRepo;
import com.tcs.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public String save(@RequestBody Student student){
        studentRepo.save(student);
        return "Success";
    }

    @RequestMapping(value = "/student/list",method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    @RequestMapping(value = "/student/{studentId}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("studentId") Integer studentId){
       studentRepo.deleteById(studentId);
       return "Success";
    }

}
