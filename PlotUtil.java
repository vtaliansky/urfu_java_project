import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlotUtil {

    public static void plotStudentsByCounty(Path out) throws Exception {
        String sql = """
            SELECT c.name, ROUND(AVG(s.students),1) AS avg_students
            FROM school s JOIN county c ON s.county_id = c.id
            GROUP BY c.name
            ORDER BY avg_students DESC
            LIMIT 10;
        """;

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        try (Connection c = DbUtil.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                ds.addValue(rs.getDouble(2), "Students", rs.getString(1));
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Average Students per County (Top-10)",
                "County", "Avg Students",
                ds,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtils.saveChartAsPNG(out.toFile(), chart, 900, 600);
    }
}
