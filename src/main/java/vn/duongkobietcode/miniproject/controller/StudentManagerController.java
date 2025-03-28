package vn.duongkobietcode.miniproject.controller;

import java.sql.Date;
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

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;

import vn.duongkobietcode.miniproject.domain.Student;
import vn.duongkobietcode.miniproject.service.StudentService;
import vn.duongkobietcode.miniproject.service.impl.StudentServiceImpl;
import vn.duongkobietcode.miniproject.utilityModel.ClassTableModel;
import vn.duongkobietcode.miniproject.view.StudentJFrame;

public class StudentManagerController {
    private JPanel jPanelView;
    private JButton jButtonAdd;
    private JTextField jTextFieldSearch;
    private JButton jButtonExport;

    private StudentService studentService = null;

    // Change TableRow by TableRowSorter because TableRow not found (unchecked
    // exception)
    private TableRowSorter<TableModel> rowSorter = null;

    private String[] columns = { "Mã học viên", "STT", "Họ tên", "Ngày sinh", "Giới tính", "SĐT", "Địa chỉ",
            "Trạng thái" };

    public StudentManagerController(JPanel jPanelView, JButton jButtonAdd, JTextField jTextFieldSearch,
            JButton jButtonExport)
            throws SQLException {
        this.jPanelView = jPanelView;
        this.jButtonAdd = jButtonAdd;
        this.jTextFieldSearch = jTextFieldSearch;
        this.jButtonExport = jButtonExport;
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

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
                    DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();
                    int selectedRowIndex = jTable.getSelectedRow();
                    selectedRowIndex = jTable.convertRowIndexToModel(selectedRowIndex);
                    System.out.println(selectedRowIndex);

                    Student student = new Student();
                    student.setId((int) jTable.getValueAt(selectedRowIndex, 0));
                    student.setName((String) jTable.getValueAt(selectedRowIndex, 2));
                    student.setBirthDate((Date) jTable.getValueAt(selectedRowIndex, 3));
                    student.setGender(jTable.getValueAt(selectedRowIndex, 4).toString().equals("Nam") ? true : false);
                    student.setPhoneNumber(jTable.getValueAt(selectedRowIndex, 5).toString());
                    student.setAddress(jTable.getValueAt(selectedRowIndex, 6).toString());
                    student.setStatus((boolean) jTable.getValueAt(selectedRowIndex, 7));
                    StudentJFrame studentJFrame = new StudentJFrame(student);
                    studentJFrame.setTitle("Thông tin học viên");
                    studentJFrame.setResizable(false);
                    studentJFrame.setLocationRelativeTo(null);
                    studentJFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            try {
                                setDataTable();
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                    });
                    studentJFrame.setVisible(true);
                }
            }
        });

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

    public void setEvent() {
        jButtonAdd.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Student student = new Student();
                student.setGender(true);
                StudentJFrame studentJFrame = new StudentJFrame(student);
                studentJFrame.setTitle("Thông tin học viên");
                studentJFrame.setLocationRelativeTo(null);
                studentJFrame.setResizable(false);
                studentJFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        try {
                            setDataTable();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
                studentJFrame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        jButtonExport.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet spreadsheet = workbook.createSheet("Học viên");

                    XSSFRow row;
                    Cell cell;

                    // Tạo CellStyle cho tiêu đề
                    CellStyle headerStyle = workbook.createCellStyle();
                    Font headerFont = workbook.createFont();
                    headerFont.setBold(true);
                    headerFont.setFontHeightInPoints((short) 14);
                    headerStyle.setFont(headerFont);
                    headerStyle.setAlignment(HorizontalAlignment.CENTER);
                    headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                    headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    headerStyle.setBorderTop(BorderStyle.THIN);
                    headerStyle.setBorderBottom(BorderStyle.THIN);
                    headerStyle.setBorderLeft(BorderStyle.THIN);
                    headerStyle.setBorderRight(BorderStyle.THIN);

                    // Tạo CellStyle cho dữ liệu
                    CellStyle dataStyle = workbook.createCellStyle();
                    dataStyle.setBorderTop(BorderStyle.THIN);
                    dataStyle.setBorderBottom(BorderStyle.THIN);
                    dataStyle.setBorderLeft(BorderStyle.THIN);
                    dataStyle.setBorderRight(BorderStyle.THIN);

                    // Tiêu đề chính
                    row = spreadsheet.createRow(0);
                    cell = row.createCell(0);
                    cell.setCellValue("DANH SÁCH HỌC VIÊN");
                    CellStyle titleStyle = workbook.createCellStyle();
                    Font titleFont = workbook.createFont();
                    titleFont.setBold(true);
                    titleFont.setFontHeightInPoints((short) 16);
                    titleStyle.setFont(titleFont);
                    titleStyle.setAlignment(HorizontalAlignment.CENTER);
                    row.setHeight((short) 500);
                    cell.setCellStyle(titleStyle);

                    // Merge các cột lại thành 1 để hiển thị tiêu đề chính
                    spreadsheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 0, 0, 5));

                    // Tiêu đề các cột
                    row = spreadsheet.createRow(1);
                    String[] headers = { "STT", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ" };
                    for (int i = 0; i < headers.length; i++) {
                        cell = row.createCell(i);
                        cell.setCellValue(headers[i]);
                        cell.setCellStyle(headerStyle);
                    }

                    // Giả lập dữ liệu
                    List<Student> listItem = studentService.findAllStudents();

                    // Thêm dữ liệu
                    for (int i = 0; i < listItem.size(); i++) {
                        Student student = listItem.get(i);
                        row = spreadsheet.createRow(2 + i);

                        cell = row.createCell(0);
                        cell.setCellValue(i + 1);
                        cell.setCellStyle(dataStyle);

                        cell = row.createCell(1);
                        cell.setCellValue(student.getName());
                        cell.setCellStyle(dataStyle);

                        cell = row.createCell(2);
                        cell.setCellValue(student.getBirthDate().toString());
                        cell.setCellStyle(dataStyle);

                        cell = row.createCell(3);
                        cell.setCellValue(student.isGender() ? "Nam" : "Nữ");
                        cell.setCellStyle(dataStyle);

                        cell = row.createCell(4);
                        cell.setCellValue(student.getPhoneNumber());
                        cell.setCellStyle(dataStyle);

                        cell = row.createCell(5);
                        cell.setCellValue(student.getAddress());
                        cell.setCellStyle(dataStyle);
                    }

                    // Tự động điều chỉnh độ rộng các cột
                    for (int i = 0; i < headers.length; i++) {
                        spreadsheet.autoSizeColumn(i);
                    }

                    // Xuất file ra
                    FileOutputStream out = new FileOutputStream(new File("D:/hv.xlsx"));
                    workbook.write(out);
                    System.out.println("Xuất file thành công!");
                    workbook.close();
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
    }
}
