package com.tcs.demo.service;

import com.tcs.demo.dto.StudentDto;
import com.tcs.demo.entity.Faculty;
import com.tcs.demo.entity.Student;
import com.tcs.demo.repo.FacultyRepo;
import com.tcs.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void save(StudentDto dto) {
        Integer facultyId = dto.getFacultyId();
        Student student=new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setSection(dto.getSection());
        if (facultyId!=null) {
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
    }

    @Override
    public List<StudentDto> getAllStudents() {
        // entity to dto class conversion
        List<Student> studentList = studentRepo.findAll();

        // stream apis -> map (one type to another type)
        return studentList.stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto(student.getId(), student.getName(),
                            student.getSection(), student.getFaculty().getName(),student.getFaculty().getId());
                    return studentDto;
                }).collect(Collectors.toList());
    }
}
