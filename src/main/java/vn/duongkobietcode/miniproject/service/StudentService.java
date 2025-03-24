package vn.duongkobietcode.miniproject.service;

import java.sql.SQLException;
import java.util.List;

import vn.duongkobietcode.miniproject.domain.Student;

public interface StudentService {
    public List<Student> findAllStudents();
}
