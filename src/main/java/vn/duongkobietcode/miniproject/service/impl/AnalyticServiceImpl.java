package vn.duongkobietcode.miniproject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.duongkobietcode.miniproject.bean.ClassBean;
import vn.duongkobietcode.miniproject.config.DatabaseConfiguration;
import vn.duongkobietcode.miniproject.service.AnalyticService;

public class AnalyticServiceImpl implements AnalyticService {
    private Connection connection;

    public AnalyticServiceImpl() {
        try {
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
            this.connection = databaseConfiguration.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassBean> getListByClass() {
        String sql = "SELECT register_date, COUNT(*) as number_of_students FROM classes group by register_date";
        try {
            List<ClassBean> classBeans = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClassBean classBean = new ClassBean();
                classBean.setRegisterDate(resultSet.getString("register_date"));
                classBean.setNumberOfStudents(resultSet.getInt("number_of_students"));
                classBeans.add(classBean);
            }
            return classBeans;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    };
}
