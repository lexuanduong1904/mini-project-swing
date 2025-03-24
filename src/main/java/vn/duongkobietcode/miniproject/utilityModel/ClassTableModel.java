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

            }
        }

        return defaultTableModel;
    }
    // defaultTableModel.set
}
