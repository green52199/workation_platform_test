package com.example.demo.service;

import com.example.demo.entity.Workation;
import com.example.demo.repository.WorkationRepository;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.time.Instant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;

@Service
public class WorkationService {
    private final WorkationRepository workationRepository;
    private final ResourceLoader resourceLoader;

    @Autowired
    public WorkationService(WorkationRepository workationRepository, ResourceLoader resourceLoader) {
        this.workationRepository = workationRepository;
        this.resourceLoader = resourceLoader;
    }

    // Method to load the CSV file from resources and save workations in the database
    public void importWorkationsFromCSV() throws IOException {
        // Load the CSV file from resources folder
        Resource resource = resourceLoader.getResource("classpath:workations.csv");

        try (CSVReader csvReader = new CSVReader(new FileReader(resource.getFile()))) {
            List<String[]> rows = csvReader.readAll();
            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                // Assuming the CSV columns match the Workation fields

                // Map each field from the CSV to the Workation entity
                Workation workation = new Workation();
                workation.setWorkationid(row[0]);  //workationId
                workation.setEmployee(row[1]);  // employee
                workation.setOrigin(row[2]);    // origin
                workation.setDestination(row[3]);  // destination
                workation.setStart(row[4]);  // start
                workation.setEnd(row[5]);

                // Parse start and end dates as Instant (ISO-8601 format expected in CSV)
//                try {
//                        // end
//                } catch (Exception e) {
//                    System.err.println("Error parsing date for row: " + String.join(",", row));
//                }

                // Parse workingDays as integer, handle nulls or invalid values
                try {
                    workation.setWorkingdays(Integer.parseInt(row[6]));  // workingDays
                } catch (NumberFormatException e) {
                    workation.setWorkingdays(0);  // Default to 0 if parsing fails
                }

                // Set risk value
                workation.setRisk(row[7]);  // risk

                // Save to the repository
                workationRepository.save(workation);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Log the error
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
