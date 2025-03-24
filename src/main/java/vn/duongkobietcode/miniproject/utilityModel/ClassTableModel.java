/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.duongkobietcode.miniproject.utilityModel;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import vn.duongkobietcode.miniproject.domain.Student;

/**
 *
 * @author ADMIN
 */
public class ClassTableModel {

    public DefaultTableModel setTableStudent(List<Student> students, String[] columns) {
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        defaultTableModel.setColumnIdentifiers(columns);
        int columnCount = columns.length;
        Object[] objects = null;
        int rows = students.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                Student student = students.get(i);
                objects = new Object[columnCount];
                objects[0] = student.getId();
                objects[1] = i + 1;
                objects[2] = student.getName();
                objects[3] = student.getBirthDate();
                objects[4] = student.isGender() == true ? "Nam" : "Nữ";
                objects[5] = student.getPhoneNumber();
                objects[6] = student.getAddress();
                objects[7] = student.isStatus();
                defaultTableModel.addRow(objects);
            }
        }

        return defaultTableModel;
    }
    // defaultTableModel.set
}
