package com.example.demo.controller;

import com.example.demo.DTO.WorkationResponse;
import com.example.demo.entity.Workation;
import com.example.demo.repository.WorkationRepository;
import com.example.demo.service.WorkationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workflex/workation")
public class WorkationController {

    @Autowired
    private WorkationService workationService;

    private final WorkationRepository workationRepository;

    // Constructor injection for WorkationRepository
    public WorkationController(WorkationRepository workationRepository) {
        this.workationRepository = workationRepository;
    }
    @CrossOrigin()
    @GetMapping("/get-data-from-csv")
    public List<WorkationResponse> getData(@RequestParam(defaultValue = "10") int count) {
        long countInDb = workationRepository.count();  // Get the count of workations in the DB

        if (countInDb == 0) {
            // If no data is found in the database, import workations from CSV
            try {
                workationService.importWorkationsFromCSV();  // Path to your CSV file
            } catch (Exception e) {
                e.printStackTrace();  // Handle any exception during CSV import
                return List.of();  // Return an empty list in case of error
            }
        }

        // Fetch all workations from the repository
        List<Workation> workations = workationRepository.findAll();

        // Map Workation entities to WorkationResponse DTOs
        return workations.stream()
                .map(workation -> new WorkationResponse(
                        workation.getWorkationid(),
                        workation.getEmployee(),
                        workation.getOrigin(),
                        workation.getDestination(),
                        workation.getStart(),
                        workation.getEnd(),
                        workation.getWorkingdays(),
                        workation.getRisk()))
                .collect(Collectors.toList());
    }
}
