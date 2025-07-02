package com.tcs.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public String save(@RequestBody Student student){
        return student.toString();
    }

}
