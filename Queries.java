import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Queries {

    // 1) Среднее число студентов по 10 county
    public static void avgStudentsByCounty() throws Exception {
        print("""
            SELECT c.name, ROUND(AVG(s.students),1) AS avg_students
            FROM school s JOIN county c ON s.county_id = c.id
            GROUP BY c.name
            ORDER BY avg_students DESC
            LIMIT 10;
        """);
    }

    // 2) Средний expenditure в 4 county (>10)
    public static void avgExpenditureSelected() throws Exception {
        print("""
            SELECT c.name, ROUND(AVG(s.expenditure),2) AS avg_exp
            FROM school s JOIN county c ON s.county_id = c.id
            WHERE c.name IN ('Fresno','Contra Costa','El Dorado','Glenn')
              AND s.expenditure > 10
            GROUP BY c.name;
        """);
    }

    // 3) Лучший math-score при двух диапазонах students
    public static void bestMathTwoRanges() throws Exception {
        print("""
            SELECT name, students, math
            FROM school
            WHERE (students BETWEEN 5000 AND 7500)
               OR (students BETWEEN 10000 AND 11000)
            ORDER BY math DESC
            LIMIT 1;
        """);
    }

    // ── helper ──
    private static void print(String sql) throws Exception {
        try (Connection c = DbUtil.getConnection();
             Statement  st = c.createStatement();
             ResultSet  rs = st.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= cols; i++)
                    System.out.printf("%-15s", rs.getString(i));
                System.out.println();
            }
            System.out.println("---");
        }
    }
}
