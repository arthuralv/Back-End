package com.example.demo.models;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class WriterToCSV {
    private static final String path =  "C:\\Users\\yamma\\Desktop\\coding\\ProjFAPESQ\\Back-End\\Back-End\\demo\\data\\cases-brazil-cities-filtered.csv";

    public void CSVWriter (ArrayList <String> row) throws IOException {

        // country,state,city,ibgeID,cod_RegiaoDeSaude,name_RegiaoDeSaude,deaths,totalCases,deaths_per_100k_inhabitants,totalCases_per_100k_inhabitants,deaths_by_totalCases,_source,date,newCases,newDeaths
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("city", "totalCases"));
        ) {
            for (String line: row) {
                csvPrinter.printRecord(Arrays.asList(line.split(",")));
            }

            csvPrinter.flush();            
        }
    }
}