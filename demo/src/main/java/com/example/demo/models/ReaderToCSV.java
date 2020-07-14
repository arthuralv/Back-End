package com.example.demo.models;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReaderToCSV {
    private static final String path = "C:\\Users\\yamma\\Desktop\\coding\\ProjFAPESQ\\Back-End\\Back-End\\demo\\data\\cases-brazil-cities.csv";

    public ArrayList <ArrayList <String>> CSVReader (){
        ArrayList <ArrayList <String> > array = new ArrayList <ArrayList <String>>();
        
        try (
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names country,state,city,ibgeID,cod_RegiaoDeSaude,name_RegiaoDeSaude,deaths,totalCases,deaths_per_100k_inhabitants,totalCases_per_100k_inhabitants,deaths_by_totalCases,_source,date,newCases,newDeaths
                String cidade = csvRecord.get("city");
                String casos = csvRecord.get("totalCases");
                
                cidade = cidade.toUpperCase().substring(0, cidade.length() - 3);

                ArrayList <String> aux;
                if (csvRecord.get("state").equals("PB")) {
                    aux = new ArrayList<String>();
                    aux.add(cidade);
                    aux.add(casos);

                    array.add(aux); 
                }
            }
        } catch (IOException e) { 
            e.printStackTrace();
        }
        
        return array;
    }
}
