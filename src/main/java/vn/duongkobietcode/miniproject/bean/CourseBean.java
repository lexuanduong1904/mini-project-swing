package vn.duongkobietcode.miniproject.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseBean {
    private String courseName;
    private Date startDate;
    private Date endDate;
}
