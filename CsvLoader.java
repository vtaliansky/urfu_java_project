import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static List<School> load(String csvPath) throws Exception {
        List<School> list = new ArrayList<>();

        try (var reader = Files.newBufferedReader(Path.of(csvPath), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> recs = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
                .withAllowMissingColumnNames()   // ← добавьте
                .parse(reader);


            for (CSVRecord r : recs) {
                School s = new School();
                s.setDistrict(   Integer.parseInt(r.get("district")) );
                s.setSchool    ( r.get("school") );
                s.setCounty    ( r.get("county") );
                s.setGrades    ( r.get("grades") );
                s.setStudents  ( Integer.parseInt(r.get("students")) );
                s.setTeachers  ( Double.parseDouble(r.get("teachers")) );
                s.setExpenditure( Double.parseDouble(r.get("expenditure")) );
                s.setMath      ( Double.parseDouble(r.get("math")) );
                list.add(s);
            }
        }
        return list;
    }
}
