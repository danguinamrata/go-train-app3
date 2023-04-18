package com.namrata2.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    private final String COMMA_DELIMITER = ",";
    public final  List<List<String>> loadCsv(final String fileName) {
        final List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    private List<String> getRecordFromLine(final String line) {
        final List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }



}
