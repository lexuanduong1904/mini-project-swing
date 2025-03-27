package vn.duongkobietcode.miniproject.service;

import java.util.List;

import vn.duongkobietcode.miniproject.domain.Student;

public interface StudentService {
    public List<Student> findAllStudents();

    public int createOrUpdateStudent(Student student);

    public int deleteStudentById(int id);
}
