package vn.duongkobietcode.miniproject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.duongkobietcode.miniproject.config.DatabaseConfiguration;
import vn.duongkobietcode.miniproject.domain.Student;
import vn.duongkobietcode.miniproject.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private Connection connection;

    public StudentServiceImpl() throws SQLException {
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        this.connection = databaseConfiguration.getConnection();
    }

    @Override
    public List<Student> findAllStudents() {
        try {
            String sql = "SELECT * FROM students";
            List<Student> students = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                // student.setBirthDate(resultSet.getTimestamp("birth_date").toInstant());
                student.setBirthDate(resultSet.getDate("birth_date"));
                student.setGender(resultSet.getBoolean("gender"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setAddress(resultSet.getString("address"));
                student.setStatus(resultSet.getBoolean("status"));
                students.add(student);
            }
            preparedStatement.close();
            resultSet.close();
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
