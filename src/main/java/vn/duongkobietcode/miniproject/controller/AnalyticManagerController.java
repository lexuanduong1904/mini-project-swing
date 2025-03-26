package vn.duongkobietcode.miniproject.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import vn.duongkobietcode.miniproject.bean.ClassBean;
import vn.duongkobietcode.miniproject.service.AnalyticService;
import vn.duongkobietcode.miniproject.service.impl.AnalyticServiceImpl;

public class AnalyticManagerController {
    private AnalyticService analyticService = null;

    public AnalyticManagerController() {
        analyticService = new AnalyticServiceImpl();
    }

    public void setDataToChart1(JPanel jPanelChart1) {
        List<ClassBean> classBeans = analyticService.getListByClass();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (classBeans != null) {
            for (ClassBean item : classBeans) {
                dataset.addValue(item.getNumberOfStudents(), "Học viên", item.getRegisterDate());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng học viên đăng ký".toUpperCase(),
                "Thời gian", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanelChart1.getWidth(), 321));

        jPanelChart1.removeAll();
        jPanelChart1.setLayout(new CardLayout());
        jPanelChart1.add(chartPanel);
        jPanelChart1.validate();
        jPanelChart1.repaint();
    }
}
