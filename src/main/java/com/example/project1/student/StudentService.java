package com.example.project1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void saveNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, Integer age, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student was not founded..."));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (age != null && !Objects.equals(student.getAge(), age)) {
            student.setAge(age);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }


    }

    public void removeStudent(Long studentId) {
        boolean isExist = studentRepository.existsById(studentId);
        if (!isExist){
            throw new IllegalStateException("student was not founded");
        }
        studentRepository.deleteById(studentId);
    }
}
