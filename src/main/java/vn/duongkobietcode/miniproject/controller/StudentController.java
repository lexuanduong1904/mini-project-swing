package vn.duongkobietcode.miniproject.controller;

import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.w3c.dom.events.MouseEvent;

import com.toedter.calendar.JDateChooser;

import vn.duongkobietcode.miniproject.domain.Student;

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

    // public StudentController(JButton jButtonSubmit, JTextField
    // jTextFieldStudentId, JTextField jTextFieldStudentName) {
    // this.jButtonSubmit = jButtonSubmit;
    // this.jTextFieldStudentId = jTextFieldStudentId;
    // this.jTextFieldStudentName = jTextFieldStudentName;
    // }

    public StudentController(JButton jButtonSubmit, JTextField jTextFieldStudentId, JTextField jTextFieldStudentName,
            JDateChooser jDateChooserBirthDate, JRadioButton jRadioMale, JRadioButton jRadioFemale,
            JTextField jTextFieldPhoneNumber, JTextArea jTextAreaAddress, JCheckBox jCheckBoxStatus) {
        this.jButtonSubmit = jButtonSubmit;
        this.jTextFieldStudentId = jTextFieldStudentId;
        this.jTextFieldStudentName = jTextFieldStudentName;
        this.jDateChooserBirthDate = jDateChooserBirthDate;
        this.jRadioMale = jRadioMale;
        this.jRadioFemale = jRadioFemale;
        this.jTextFieldPhoneNumber = jTextFieldPhoneNumber;
        this.jTextAreaAddress = jTextAreaAddress;
        this.jCheckBoxStatus = jCheckBoxStatus;
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
    }

    public void setEvent() {
        jButtonSubmit.addMouseListener(new MouseAdapter() {
            // @Override
            // public void mouseClicked(MouseEvent e) {
            // }

            // @Override
            // public void mouseEntered(MouseEvent e) {
            // }

            // @Override
            // public void mouseExited(MouseEvent e) {

            // }
        });
    }
}
