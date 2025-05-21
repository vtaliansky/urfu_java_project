Проект «Schools» (Java 21 + SQLite)
Демонстрационная консольная программа:

- читает файл CSV schools.csv;
- строит локальную базу SQLite «schools.db» по 3-й нормальной форме;
- выполняет 3 SQL-запроса из задания;
- сохраняет диаграмму «Average Students per County (Top 10)» в avg_students_county.png.

В каталоге lib лежат все необходимые JAR-файлы:

sqlite-jdbc-3.46.0.0.jar
commons-csv-1.10.0.jar
jfreechart-1.5.4.jar
jcommon-1.0.24.jar
slf4j-api-2.0.9.jar
slf4j-simple-2.0.9.jar

Структура каталога
java_project
├─ lib / внешние библиотеки
├─ src файлы *.java Main, CsvLoader, DbUtil, DbPopulator, Queries, PlotUtil, …
├─ schools.csv входные данные (UTF-8)
└─ out / компилированные .class (создаётся автоматически)

После первого запуска появятся ещё два файла:

schools.db
avg_students_county.png

Сборка и запуск
открыть терминал в папке java_project;

javac -d out -cp "lib/*" *.java
java  -cp "out;lib/*" Main


Пример вывода:

--- Average students by county ---
Orange         8223.9
San Bernardino 6469.7
San Diego      6170.3
Santa Clara    5931.9
Los Angeles    5830.9
Ventura        4627.8
Monterey       3549.4
Sacramento     3511.4
San Mateo      3289.2
Kern           3108.3
---
--- Average expenditure (Fresno, Contra Costa, El Dorado, Glenn) ---
Fresno         5396.98
Contra Costa   5269.45
El Dorado      5309.97
Glenn          4363.35
---
--- Best math score (5 000–7 500 и 10 000–11 000 students) ---
Encinitas Union Elementary  5259  678.60
---
**Chart saved to avg_students_county.png**
