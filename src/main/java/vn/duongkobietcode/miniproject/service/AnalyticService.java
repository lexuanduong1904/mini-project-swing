package vn.duongkobietcode.miniproject.service;

import java.util.List;

import vn.duongkobietcode.miniproject.bean.ClassBean;
import vn.duongkobietcode.miniproject.bean.CourseBean;

public interface AnalyticService {
    public List<ClassBean> getListByClass();

    public List<CourseBean> getListByCourse();
}
