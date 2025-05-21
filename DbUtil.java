import java.sql.*;

public class DbUtil {
    private static final String URL = "jdbc:sqlite:schools.db";

    /** загружаем драйвер вручную один раз */
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite JDBC driver not found!", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initDb() throws java.sql.SQLException {
        String ddlCounty = """
            CREATE TABLE IF NOT EXISTS county(
                id   INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT UNIQUE NOT NULL
            );""";

        String ddlSchool = """
            CREATE TABLE IF NOT EXISTS school(
                id          INTEGER PRIMARY KEY,
                name        TEXT NOT NULL,
                grades      TEXT,
                students    INTEGER,
                teachers    REAL,
                expenditure REAL,
                math        REAL,
                county_id   INTEGER REFERENCES county(id)
            );""";

        try (Connection c = getConnection();
             Statement  st = c.createStatement()) {
            st.execute(ddlCounty);
            st.execute(ddlSchool);
        }
    }
}
