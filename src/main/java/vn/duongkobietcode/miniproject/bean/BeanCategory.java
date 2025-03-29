package vn.duongkobietcode.miniproject.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeanCategory {
    private String kind;
    private JPanel jPanel;
    private JLabel jLabel;

    public BeanCategory(String kind, JPanel jPanel, JLabel jLabel) {
        this.kind = kind;
        this.jPanel = jPanel;
        this.jLabel = jLabel;
    }

    public BeanCategory() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJPanel() {
        return jPanel;
    }

    public void setJPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JLabel getJLabel() {
        return jLabel;
    }

    public void setJLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

}
