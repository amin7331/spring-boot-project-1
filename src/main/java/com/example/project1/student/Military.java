package com.example.project1.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Military {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    @OneToMany(mappedBy = "military")
    private List<Student> studentList;

    public Military() {

    }

    public Military(Long id, String type, List<Student> studentList) {
        this.id = id;
        this.type = type;
        this.studentList = studentList;
    }

    public Military(String type, List<Student> studentList) {
        this.type = type;
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Military{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
