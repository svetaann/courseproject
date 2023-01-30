package ru.misis.courseproject;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import ru.misis.courseproject.models.StatisticsModel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVCreator {
    @Getter
    @Setter
    public String pathToCsv;

    public void createCSV(List<StatisticsModel> source) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathToCsv));
             CSVPrinter csvPrinter =
                     new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Тип", "Описание", "Количество", "Сумма", "Дисперсия"));) {
            for (StatisticsModel sm : source) {
                csvPrinter.printRecord(sm.getType(), sm.getDescription(), sm.getNumber().toString(), sm.getAmount().toString(), sm.getDispersion().toString());
            }
            csvPrinter.flush();
        }
    }
}
