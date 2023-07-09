package com.db.autocomplete.autocomplete.station.controller;

import com.db.autocomplete.autocomplete.station.model.response.AutoCompleteResponse;
import com.db.autocomplete.autocomplete.station.service.StationServiceImpl;
import com.db.autocomplete.autocomplete.station.model.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller to accept the HTTP Request at /api/v1/auto-complete endpoint.
 */
@RestController
@RequestMapping("/api/v1/auto-complete")
public class StationController {
    @Autowired
    private StationServiceImpl service;

    /**
     * if no Name to autocomplete entered, an Error will be thrown.
     * @return Error Response.
     */
    @GetMapping("/")
    public ResponseEntity<?> emptyAutoComplete(){
        // Perform input validation for empty or missing parameter
        return ResponseEntity.badRequest().body(
                new ErrorResponse("000", "Input parameter is missing or empty")
        );
    }

    /**
     * get all Station that contains the name parameter
     * @param name to autocomplete
     * @return List of Stations
     */
    @GetMapping("/{name}")
    public ResponseEntity<?> autoCompleteStations(@PathVariable String name) {
        // Perform input validation for allowed characters
        if (!name.matches("[a-zA-ZäöüÄÖÜß]+")) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("001", "Alphanumeric characters are not allowed")
            );
        }

        // Perform input validation for minimum length requirement
        if (name.length() < 3) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("002", "Input parameter length must be at least three characters")
            );
        }

        AutoCompleteResponse response = service.getAutocompleteStations(name);

        if (response.getStation_list().isEmpty()){
            return ResponseEntity.ok().body(
                    new ErrorResponse("003", "No matching stations found")
            );
        }

        return ResponseEntity.ok(response);
    }

    /**
     * get all Station Mapping
     * @return All Stations
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllStations() {
       return ResponseEntity.ok(service.getAllStations());
    }
}
