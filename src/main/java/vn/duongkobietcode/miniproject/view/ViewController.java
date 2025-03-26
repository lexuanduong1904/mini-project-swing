package vn.duongkobietcode.miniproject.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import vn.duongkobietcode.miniproject.bean.BeanCategory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ViewController {
    private JPanel root;
    private String kindSelected = "";
    private List<BeanCategory> categories = null;

    public ViewController(JPanel root) {
        this.root = root;
    }

    public void setView(JPanel jPanelItem, JLabel jLabelItem) {
        kindSelected = "Home";
        jPanelItem.setBackground(new ColorUIResource(96, 100, 191));
        jLabelItem.setBackground(new ColorUIResource(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new HomeJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<BeanCategory> categories) {
        this.categories = categories;
        for (BeanCategory item : categories) {
            item.getJLabel().addMouseListener(new LabelEvent(item.getKind(), item.getJPanel(), item.getJLabel()));
        }
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;

        private JPanel jPanelItem;
        private JLabel jLabelItem;

        public LabelEvent(String kind, JPanel jPanelItem, JLabel jLabelItem) {
            this.kind = kind;
            this.jPanelItem = jPanelItem;
            this.jLabelItem = jLabelItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            node = switch (kind) {
                case "Home" -> new HomeJPanel();
                case "Student" -> new StudentsJPanel();
                case "Course" -> new CoursesJPanel();
                default -> new HomeJPanel();
            };
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            changeBackgroundColor(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jPanelItem.setBackground(new ColorUIResource(96, 100, 191));
            jLabelItem.setBackground(new ColorUIResource(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            System.out.println("bla bla method needs overriding!");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jPanelItem.setBackground(new ColorUIResource(96, 100, 191));
            jLabelItem.setBackground(new ColorUIResource(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jPanelItem.setBackground(new ColorUIResource(76, 175, 80));
                jLabelItem.setBackground(new ColorUIResource(76, 175, 80));
            }
        }

    }

    private void changeBackgroundColor(String kind) {
        for (BeanCategory item : categories) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJPanel().setBackground(new ColorUIResource(96, 100, 191));
                item.getJLabel().setBackground(new ColorUIResource(96, 100, 191));
            } else {
                item.getJPanel().setBackground(new ColorUIResource(76, 175, 80));
                item.getJLabel().setBackground(new ColorUIResource(76, 175, 80));
            }
        }
    }
}
