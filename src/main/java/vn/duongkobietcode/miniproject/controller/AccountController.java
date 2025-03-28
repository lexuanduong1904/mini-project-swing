package vn.duongkobietcode.miniproject.controller;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;

import lombok.AllArgsConstructor;
import vn.duongkobietcode.miniproject.domain.Account;
import vn.duongkobietcode.miniproject.service.AccountService;
import vn.duongkobietcode.miniproject.service.impl.AccountServiceImpl;
import vn.duongkobietcode.miniproject.view.MainJFrame;

public class AccountController {
    private JDialog loginJDialog;
    private JButton jButtonLogin;
    private JTextField jTextFieldUsername;
    private JPasswordField jPasswordField;
    private JLabel jLabelMessage;

    private AccountService accountService;

    public AccountController(JDialog loginJDialog, JButton jButtonLogin, JTextField jTextFieldUsername,
            JPasswordField jPasswordField, JLabel jLabelMessage) {
        this.loginJDialog = loginJDialog;
        this.jButtonLogin = jButtonLogin;
        this.jTextFieldUsername = jTextFieldUsername;
        this.jPasswordField = jPasswordField;
        this.jLabelMessage = jLabelMessage;
        this.accountService = new AccountServiceImpl();
    }

    public void setEvent() {
        jButtonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    String username = jTextFieldUsername.getText();
                    String password = new String(jPasswordField.getPassword());
                    if (username.length() == 0 || password.length() == 0) {
                        jLabelMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        Account account = accountService.login(username, password);
                        if (account == null) {
                            jLabelMessage.setText("Tên đăng nhập hoặc mật khẩu không đúng");
                        } else {
                            if (account.isStatus() == false) {
                                jLabelMessage.setText("Tài khoản bị khóa");
                            } else {
                                loginJDialog.dispose();
                                MainJFrame mainJFrame = new MainJFrame();
                                mainJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                mainJFrame.setVisible(true);
                            }
                        }
                    }
                } catch (Exception e) {
                    jLabelMessage.setText("External error: " + e.getMessage());
                }
            }
        });
    }
}
