package com.tcs.demo.controller;

import com.tcs.demo.entity.Faculty;
import com.tcs.demo.entity.Student;
import com.tcs.demo.repo.FacultyRepo;
import com.tcs.demo.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private FacultyRepo facultyRepo;

    public FacultyController(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Faculty faculty){
        facultyRepo.save(faculty);
        return "Success";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Faculty> getAllFaculty(){
        List<Faculty> faculties = facultyRepo.findAll();
        return faculties;
    }


}
