package GraphCreator;

import java.io.*;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.HashMap;
import java.util.Map;

public class GraphPanels {

    public static JPanel createGraph(File inFile, Map<String, Double> dataMap, String type, String title, String x, String y) {
        if(type.equals("PIE")) {
            DefaultPieDataset data = new DefaultPieDataset();
            for(Map.Entry<String, Double> entry : dataMap.entrySet()) {
                data.setValue(entry.getKey(), entry.getValue());
            }
            JFreeChart pie = ChartFactory.createPieChart(title, data, true, true, false);
            return new ChartPanel(pie);
        }
        else if(type.equals("BAR")) {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            for(Map.Entry<String, Double> entry : dataMap.entrySet()) {
                data.setValue(entry.getValue(), entry.getKey(), "");
            }
            JFreeChart bar = ChartFactory.createBarChart(title, x, y, data);
            return new ChartPanel(bar);
        }
        //Line graphs are being put on hold at this time
//        else if(type.equals("LINE")) {
//            Map<Double, Double> lineMap = new HashMap<>();
//            lineMap = lineData(inFile);
//            DefaultCategoryDataset data = new DefaultCategoryDataset();
//        }
        //this should never run
        return new JPanel();
    }

}
