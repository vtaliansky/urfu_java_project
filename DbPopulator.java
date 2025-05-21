import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DbPopulator {

    public static void populate(List<School> schools) throws Exception {
        String insCounty = "INSERT OR IGNORE INTO county(name) VALUES (?)";
        String selCounty = "SELECT id FROM county WHERE name = ?";
        String insSchool = """
            INSERT OR REPLACE INTO school
            (id, name, grades, students, teachers,
             expenditure, math, county_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
        """;

        try (Connection c = DbUtil.getConnection()) {
            c.setAutoCommit(false);
            PreparedStatement psCIns = c.prepareStatement(insCounty);
            PreparedStatement psCSel = c.prepareStatement(selCounty);
            PreparedStatement psSch  = c.prepareStatement(insSchool);

            for (School s : schools) {
                // county
                psCIns.setString(1, s.getCounty());
                psCIns.executeUpdate();

                psCSel.setString(1, s.getCounty());
                ResultSet rs = psCSel.executeQuery();
                int countyId = rs.next() ? rs.getInt(1) : 0;

                // school
                psSch.setInt   (1, s.getDistrict());
                psSch.setString(2, s.getSchool());
                psSch.setString(3, s.getGrades());
                psSch.setInt   (4, s.getStudents());
                psSch.setDouble(5, s.getTeachers());
                psSch.setDouble(6, s.getExpenditure());
                psSch.setDouble(7, s.getMath());
                psSch.setInt   (8, countyId);
                psSch.addBatch();
            }
            psSch.executeBatch();
            c.commit();
        }
    }
}
