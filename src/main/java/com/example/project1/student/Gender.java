package com.example.project1.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Gender {
    @Id
    @GeneratedValue
    private Long id;
    private String gender;

    @OneToMany(mappedBy = "gender")
    private List<Student> studentList;

    public Gender() {
    }

    public Gender(Long id, String gender, List<Student> studentList) {
        this.id = id;
        this.gender = gender;
        this.studentList = studentList;
    }

    public Gender(String gender, List<Student> studentList) {
        this.gender = gender;
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
