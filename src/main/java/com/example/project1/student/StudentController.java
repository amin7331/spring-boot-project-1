package com.example.project1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("api/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("api/students")
    public void saveNewStudent(@RequestBody Student student){
        studentService.saveNewStudent(student);
    }

}
