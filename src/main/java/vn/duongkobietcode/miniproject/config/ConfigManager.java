package vn.duongkobietcode.miniproject.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    // khoi tao doi tuong Properties
    private Properties properties = new Properties();

    // ham tao
    public ConfigManager() {
        try {
            // load file config.properties
            properties.load(new FileInputStream(
                    "src\\main\\java\\vn\\duongkobietcode\\miniproject\\resources\\application.properties"));
        } catch (IOException e) {
            System.out.println("Error getting properties: " + e.getMessage());
        }
    }

    public String getProperties(String key) {
        return properties.getProperty(key);
    }
}
