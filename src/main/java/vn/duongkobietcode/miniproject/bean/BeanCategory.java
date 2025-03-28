package vn.duongkobietcode.miniproject.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BeanCategory {
    private String kind;
    private JPanel jPanel;
    private JLabel jLabel;

    public BeanCategory(String kind, JPanel jPanel, JLabel jLabel) {
        this.kind = kind;
        this.jPanel = jPanel;
        this.jLabel = jLabel;
    }
}
