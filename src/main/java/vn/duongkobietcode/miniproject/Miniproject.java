/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vn.duongkobietcode.miniproject;

import vn.duongkobietcode.miniproject.view.LoginJDialog;
import vn.duongkobietcode.miniproject.view.MainJFrame;

/**
 *
 * @author ADMIN
 */
public class Miniproject {

    public static void main(String[] args) throws Exception {
        LoginJDialog dialog = new LoginJDialog(null, true);
        dialog.setTitle("Đăng nhập");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
