package vn.duongkobietcode.miniproject.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeanCategory {
    private String kind;
    private JPanel jPanel;
    private JLabel jLabel;
}
