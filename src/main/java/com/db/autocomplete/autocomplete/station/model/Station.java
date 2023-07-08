package com.db.autocomplete.autocomplete.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Station Class
 * using Lombok to reduce boilerplate code
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Station {
    /**
     * Station Number
     */
    private String evaNr;
    /**
     * Station Code
     */
    private String ds100;
    /**
     * Name of the Station
     */
    private String name;
    /**
     * Type of Station traffic (Fernverkehr, Nahverkehr)
     */
    private String traffic;
    /**
     * length of the Station
     */
    private double length;
    /**
     * width of the Station
     */
    private double width;
}

