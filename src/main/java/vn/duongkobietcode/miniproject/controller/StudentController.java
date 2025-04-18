package vn.duongkobietcode.miniproject.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import vn.duongkobietcode.miniproject.domain.Student;
import vn.duongkobietcode.miniproject.service.StudentService;
import vn.duongkobietcode.miniproject.service.impl.StudentServiceImpl;

public class StudentController {
    private JButton jButtonSubmit;
    private JTextField jTextFieldStudentId;
    private JTextField jTextFieldStudentName;
    private JDateChooser jDateChooserBirthDate;
    private JRadioButton jRadioMale;
    private JRadioButton jRadioFemale;
    private JTextField jTextFieldPhoneNumber;
    private JTextArea jTextAreaAddress;
    private JCheckBox jCheckBoxStatus;
    private JLabel jLabelMessage;
    private JButton jButtonDelete;

    private Student student = null;
    private StudentService studentService;
    // public StudentController(JButton jButtonSubmit, JTextField
    // jTextFieldStudentId, JTextField jTextFieldStudentName) {
    // this.jButtonSubmit = jButtonSubmit;
    // this.jTextFieldStudentId = jTextFieldStudentId;
    // this.jTextFieldStudentName = jTextFieldStudentName;
    // }

    public StudentController(JButton jButtonSubmit, JTextField jTextFieldStudentId, JTextField jTextFieldStudentName,
            JDateChooser jDateChooserBirthDate, JRadioButton jRadioMale, JRadioButton jRadioFemale,
            JTextField jTextFieldPhoneNumber, JTextArea jTextAreaAddress, JCheckBox jCheckBoxStatus,
            JLabel jLabelMessage, JButton jButtonDelete) {
        this.jButtonSubmit = jButtonSubmit;
        this.jTextFieldStudentId = jTextFieldStudentId;
        this.jTextFieldStudentName = jTextFieldStudentName;
        this.jDateChooserBirthDate = jDateChooserBirthDate;
        this.jRadioMale = jRadioMale;
        this.jRadioFemale = jRadioFemale;
        this.jTextFieldPhoneNumber = jTextFieldPhoneNumber;
        this.jTextAreaAddress = jTextAreaAddress;
        this.jCheckBoxStatus = jCheckBoxStatus;
        this.jLabelMessage = jLabelMessage;
        this.jButtonDelete = jButtonDelete;

        this.student = new Student();
        try {
            this.studentService = new StudentServiceImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setView(Student student) {
        this.jTextFieldStudentId.setText("#" + String.valueOf(student.getId()));
        this.jTextFieldStudentName.setText(student.getName());
        this.jDateChooserBirthDate.setDate(student.getBirthDate());
        if (student.isGender()) {
            this.jRadioMale.setSelected(true);
            this.jRadioFemale.setSelected(false);
        } else {
            this.jRadioMale.setSelected(false);
            this.jRadioFemale.setSelected(true);
        }
        this.jTextFieldPhoneNumber.setText(student.getPhoneNumber());
        this.jTextAreaAddress.setText(student.getAddress());
        this.jCheckBoxStatus.setSelected(student.isStatus());
        this.student = student;
    }

    public void setEvent() {
        jButtonSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jTextFieldStudentName.getText().length() == 0 || jDateChooserBirthDate.getDate() == null) {
                    jLabelMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
                } else {
                    student.setName(jTextFieldStudentName.getText());
                    student.setBirthDate(covertDateToDateSql(jDateChooserBirthDate.getDate()));
                    student.setGender(jRadioMale.isSelected());
                    student.setPhoneNumber(jTextFieldPhoneNumber.getText());
                    student.setAddress(jTextAreaAddress.getText());
                    student.setStatus(jCheckBoxStatus.isSelected());
                    if (showDialog()) {
                        int lastId = studentService.createOrUpdateStudent(student);
                        if (lastId > 0) {
                            student.setId(lastId);
                            jTextFieldStudentId.setText("#" + student.getId());
                            jLabelMessage.setText("Dữ liệu mới đã được cập nhật!");
                        } else {
                            jLabelMessage.setText("Dữ liệu mới cập nhật thất bại!");
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        jButtonDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // get id from jTextFieldStudentId (#xx)
                int id = 0;
                try {
                    id = Integer.parseInt(jTextFieldStudentId.getText().substring(1));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (id == 0) {
                    jLabelMessage.setText("Mã học viên không hợp lệ!");
                } else {
                    if (showDeleteDialog()) {
                        int rowsAffect = studentService.deleteStudentById(id);
                        if (rowsAffect > 0) {
                            jLabelMessage.setText("Xoá thành công!");
                        } else {
                            jLabelMessage.setText("Xoá thất bại!");
                        }
                    }
                }
            }
        });
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private boolean showDeleteDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn xoá hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
