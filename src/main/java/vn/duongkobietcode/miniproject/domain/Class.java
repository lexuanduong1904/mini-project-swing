/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.duongkobietcode.miniproject.domain;

import java.io.Serializable;
import java.time.Instant;

public class Class implements Serializable {
    private int id;
    private Course course;
    private Student student;
    private Instant registerDate;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Class() {
    }

    public Class(int id, Course course, Student student, Instant registerDate, boolean status) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.registerDate = registerDate;
        this.status = status;
    }

}
