package com.example.project1.student;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "student.sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student.sequence", sequenceName = "project-1.sequence", allocationSize = 1)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Military military;


    public Student() {
    }

    public Student(Long id, String name, Integer age, String email, Gender gender, Military military) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.military = military;
    }

    public Student(String name, Integer age, String email, Gender gender, Military military) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.military = military;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Military getMilitary() {
        return military;
    }

    public void setMilitary(Military military) {
        this.military = military;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", military=" + military +
                '}';
    }
}
