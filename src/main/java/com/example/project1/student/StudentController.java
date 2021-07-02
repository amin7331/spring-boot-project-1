package com.example.project1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("api/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("api/students")
    public void saveNewStudent(@RequestBody Student student) {
        studentService.saveNewStudent(student);
    }

    @PutMapping("api/students/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Integer age,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, age, email);

    }
    @DeleteMapping("api/students/{studentId}")
    public void removeStudent(@PathVariable("studentId") Long studentId){
        studentService.removeStudent(studentId);
    }
}
