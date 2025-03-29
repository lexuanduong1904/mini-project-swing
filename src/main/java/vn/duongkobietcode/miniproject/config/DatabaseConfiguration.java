/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.duongkobietcode.miniproject.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */

public class DatabaseConfiguration {
    // private ConfigManager configManager;

    private String DB_URL = "";
    private String DB_USERNAME = "";
    private String DB_PASSWORD = "";

    public DatabaseConfiguration() {
        ConfigManager configManager = new ConfigManager();
        DB_URL = configManager.getProperties("swing.datasource.url");
        DB_USERNAME = configManager.getProperties("swing.datasource.username");
        DB_PASSWORD = configManager.getProperties("swing.datasource.password");
    }

    public void showInfo() {
        System.out.println("DB_URL: " + DB_URL);
        System.out.println("DB_USERNAME: " + DB_USERNAME);
        System.out.println("DB_PASSWORD: " + DB_PASSWORD);
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        System.out.println(">>>> Database connected!");
        return conn;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String dB_URL) {
        DB_URL = dB_URL;
    }

    public String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public void setDB_USERNAME(String dB_USERNAME) {
        DB_USERNAME = dB_USERNAME;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public void setDB_PASSWORD(String dB_PASSWORD) {
        DB_PASSWORD = dB_PASSWORD;
    }

}
