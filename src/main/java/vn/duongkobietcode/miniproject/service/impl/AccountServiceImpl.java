package vn.duongkobietcode.miniproject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.duongkobietcode.miniproject.config.DatabaseConfiguration;
import vn.duongkobietcode.miniproject.domain.Account;
import vn.duongkobietcode.miniproject.service.AccountService;

public class AccountServiceImpl implements AccountService, AutoCloseable {
    private Connection connection;

    public AccountServiceImpl() {
        try {
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
            this.connection = databaseConfiguration.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account login(String username, String password) {
        String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
        Account account = null;

        try {
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setStatus(resultSet.getBoolean("status"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
