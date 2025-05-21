# Проект *Schools* (Java + SQLite)

Демонстрационная консольная программа:

* читает файл CSV `schools.csv`;
* строит локальную базу SQLite `schools.db` по 3-й нормальной форме;
* выполняет 3 SQL-запроса из задания;
* сохраняет диаграмму **Average Students per County (Top 10)** в `avg_students_county.png`.

---

## Требуемые JAR-файлы

* `sqlite-jdbc-3.46.0.0.jar`  
* `commons-csv-1.10.0.jar`  
* `jfreechart-1.5.4.jar`   `jcommon-1.0.24.jar`  
* `slf4j-api-2.0.9.jar`    `slf4j-simple-2.0.9.jar`

---

## Структура каталога

java_project
  -  lib/ внешние библиотеки
  -  src *.java Main, CsvLoader, …
  -  schools.csv входные данные (UTF-8)
  - out/ скомпилированные .class (создаётся автоматически)


После первого запуска появятся ещё два файла:

* `schools.db`  
* `avg_students_county.png`

---

## Сборка и запуск

Откройте терминал в папке **`java_project`** и выполните:

-  javac -d out -cp "lib/*" *.java
-  java  -cp "out;lib/*" Main


Пример вывода:

```

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
---Avg expenditure (4 counties)---
Contra Costa   5269.45
El Dorado      5309.97
Fresno         5396.98
Glenn          4363.35        
---
---Best math (ranges)---
Encinitas Union Elementary5259           678.599975585938
---
Chart saved`: avg_students_county.png
```


Пример графика:
![avg_students_county](https://github.com/user-attachments/assets/e7e7813c-7c8b-45c4-8239-2384dc777ae3)


