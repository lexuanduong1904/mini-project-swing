package vn.duongkobietcode.miniproject.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import vn.duongkobietcode.miniproject.domain.Student;
import vn.duongkobietcode.miniproject.service.StudentService;
import vn.duongkobietcode.miniproject.service.impl.StudentServiceImpl;
import vn.duongkobietcode.miniproject.utilityModel.ClassTableModel;

public class StudentController {
    private JPanel jPanelView;
    private JButton jButtonAdd;
    private JTextField jTextFieldSearch;

    private StudentService studentService = null;

    // Change TableRow by TableRowSorter because TableRow not found (unchecked
    // exception)
    private TableRowSorter<TableModel> rowSorter = null;

    private String[] columns = { "Mã học viên", "STT", "Họ tên", "Ngày sinh", "Giới tính", "SĐT", "Địa chỉ",
            "Trạng thái" };

    public StudentController(JPanel jPanelView, JButton jButtonAdd, JTextField jTextFieldSearch) throws SQLException {
        this.jPanelView = jPanelView;
        this.jButtonAdd = jButtonAdd;
        this.jTextFieldSearch = jTextFieldSearch;
        this.studentService = new StudentServiceImpl();
    }

    public void setDataTable() throws SQLException {
        List<Student> students = studentService.findAllStudents();
        DefaultTableModel defaultTableModel = new ClassTableModel().setTableStudent(students, columns);
        JTable jTable = new JTable(defaultTableModel);
        rowSorter = new TableRowSorter<>(jTable.getModel());
        jTable.setRowSorter(rowSorter);

        jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jTextFieldSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jTextFieldSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'changedUpdate'");
            }
        });

        jTable.getColumnModel().getColumn(0).setMinWidth(0);
        jTable.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTable.getColumnModel().getColumn(1).setMinWidth(80);
        jTable.getColumnModel().getColumn(1).setMaxWidth(80);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(80);

        jTable.getTableHeader().setFont(new FontUIResource("Arial", FontUIResource.BOLD, 14));
        jTable.getTableHeader().setPreferredSize(new DimensionUIResource(100, 50));
        jTable.setRowHeight(50);
        jTable.validate();
        jTable.repaint();

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.getViewport().add(jTable);
        jScrollPane.setPreferredSize(new DimensionUIResource(1300, 400));

        jPanelView.removeAll();
        jPanelView.setLayout(new BorderLayout());
        jPanelView.add(jScrollPane);
        jPanelView.validate();
        jPanelView.repaint();
    }
}
