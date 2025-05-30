package com.pluralsight.utils;

import com.pluralsight.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FileManager {
    public static void save(Order currentOrder) {

        String dir = "receipts/";
        File filePath = new File(dir,createFileName());

        System.out.println(createFileName());

        try(FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(String.valueOf(currentOrder));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static String createFileName() {
        LocalDateTime currentDate = LocalDateTime.now();
        StringBuilder fileName = new StringBuilder();

        System.out.println(currentDate.toLocalDate());

        for (String dateString: currentDate.toLocalDate().toString().split("-")){
            fileName.append(dateString);
        }

        fileName.append("-");

        for (String timeString: currentDate.toLocalTime().truncatedTo(ChronoUnit.SECONDS).toString().split(":")){
            fileName.append(timeString);
        }
        fileName.append(".txt");

        return fileName.toString();
    }
}
