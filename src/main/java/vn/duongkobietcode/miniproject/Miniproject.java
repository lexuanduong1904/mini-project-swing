/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vn.duongkobietcode.miniproject;

import java.sql.SQLException;
import vn.duongkobietcode.miniproject.config.DatabaseConfiguration;
import vn.duongkobietcode.miniproject.view.MainJFrame;

/**
 *
 * @author ADMIN
 */
public class Miniproject {

    public static void main(String[] args) throws SQLException {
        new MainJFrame().setVisible(true);
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        databaseConfiguration.getConnection();
    }
}
