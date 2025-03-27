package vn.duongkobietcode.miniproject.service.impl;

import java.sql.Connection;
import java.sql.Date;
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

    @Override
    public int createOrUpdateStudent(Student student) {
        try {
            String sql = "INSERT INTO `students` (`id`, `name`, `birth_date`, `gender`, `phone_number`, `address`, `status`) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE name = VALUES(name), birth_date = VALUES(birth_date), gender = VALUES(gender), phone_number = VALUES(phone_number), address = VALUES(address), status = VALUES(status);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setDate(3, new Date(student.getBirthDate().getTime()));
            preparedStatement.setBoolean(4, student.isGender());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setBoolean(7, student.isStatus());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int generatedKey = 0;
            if (resultSet.next()) {
                generatedKey = resultSet.getInt(1);
            }
            preparedStatement.close();
            return generatedKey;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    };

    @Override
    public int deleteStudentById(int id) {
        try {
            String sql_1 = "DELETE FROM `students` WHERE id = ?";
            String sql_2 = "DELETE FROM `classes` WHERE student_id = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql_2);
            preparedStatement2.setString(1, id + "");
            preparedStatement2.executeUpdate();
            preparedStatement2.close();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql_1);
            preparedStatement1.setString(1, id + "");
            int rowsAffect = preparedStatement1.executeUpdate();
            preparedStatement1.close();
            return rowsAffect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
