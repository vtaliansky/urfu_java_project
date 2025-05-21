import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        // 1. Парсим CSV
        List<School> schools = CsvLoader.load("Школы.csv");

        // 2. База
        DbUtil.initDb();
        DbPopulator.populate(schools);

        // 3. Запросы
        System.out.println("--- Average students by county ---");
        Queries.avgStudentsByCounty();

        System.out.println("---Avg expenditure (4 counties)---");
        Queries.avgExpenditureSelected();

        System.out.println("---Best math (ranges)---");
        Queries.bestMathTwoRanges();

        // 4. График
        PlotUtil.plotStudentsByCounty(Path.of("avg_students_county.png"));
        System.out.println("Chart saved`: avg_students_county.png");
    }
}

