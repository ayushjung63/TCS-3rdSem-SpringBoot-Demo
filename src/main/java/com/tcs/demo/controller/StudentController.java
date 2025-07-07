package com.tcs.demo.controller;

import com.tcs.demo.entity.Faculty;
import com.tcs.demo.repo.FacultyRepo;
import com.tcs.demo.repo.StudentRepo;
import com.tcs.demo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private StudentRepo studentRepo;
    private FacultyRepo facultyRepo;

    public StudentController(StudentRepo studentRepo,FacultyRepo facultyRepo) {
        this.studentRepo = studentRepo;
        this.facultyRepo = facultyRepo;
    }

    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public String save(@RequestBody Student student){
        Faculty faculty = student.getFaculty();
        if (faculty != null && faculty.getId()!=null) {
            Integer facultyId = faculty.getId();
            Optional<Faculty> facultyOptional = facultyRepo.findById(facultyId);
            if (facultyOptional.isPresent()) {
                student.setFaculty(facultyOptional.get());
            }else{
                throw new RuntimeException("Faculty not found with id "+facultyId);
            }
        }else{
            throw new RuntimeException("Faculty is mandatory");
        }
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

    @RequestMapping(value = "/student/{studentId}",method = RequestMethod.GET)
    public Student getById(@PathVariable("studentId") Integer studentId){
        Optional<Student> studentOptional = studentRepo.findById(studentId);
        if (studentOptional.isPresent()){
            Student s1 = studentOptional.get();
            return s1;
        }
       throw new RuntimeException("Student not found with id "+studentId);
    }

}
